import java.sql.Connection;
import java.sql.Driver;
//import java.sql.DriverManager;
//import java.sql.SQLException;
import java.sql.*;
//import com.mysql.cj.jdbc.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

public class MySqlAdsDao implements Ads {

    private Connection connection;

//    static Config config = new Config();
    public MySqlAdsDao(Config config){
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Ad> all() {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ads");
            return generateAds(rs);
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return null;

    }

    public Long insert(Ad ad) {
        List<Ad> ads = new ArrayList<>();
//        static Config config = new Config();
        // make sure we have ads
        if (ads == null) {
            ads = generateAds(config);
        }
        // we'll assign an "id" here based on the size of the ads list
        // really the database would handle this
        ad.setId((long) ads.size());
        ads.add(ad);
        return ad.getId();
    }
//
    private List<Ad> generateAds(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();

        while (rs.next()){
            ads.add(new Ad(
                    rs.getLong("id"),
                    rs.getLong("user_id"),
                    rs.getString("title"),
                    rs.getString("description")
            ));
        }
        return ads;
    }

    @Override
    public  List<Ad> search(String term){
        String sql = "SELECT * FROM ads WHERE title LIKE ?";
        String searchTermWithWildcards = "%" + term + "%";

        ResultSet rs;
        try  {
            PreparedStatement stmt = connection.prepareStatement(sql)
            stmt.setString(1, searchTermWithWildcards);

            ResultSet rs = stmt.executeQuery();
            return generateAds(rs);
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }

        return null;
    }
}
