package com.codeup.adlister.dao;
import java.sql.*;

//import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;

//import javax.servlet.jsp.jstl.core.Config;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Ad> all() {
//        Statement stmt = null;

//        String sql = "SELECT * FROM ads";
        try {
            Statement stmt = connection.createStatement("SELECT * FROM ads");
            stmt = connection.createStatement();

//            String searchTermWithWildcards = "%" + term + "%";
            ResultSet rs = stmt.executeQuery("SELECT * FROM ads");
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {

        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO ads(user_id, title, description) VALUES(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
//            stmt.executeUpdate(createInsertQuery(ad), Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
    stmt.setString(2, ad.getTitle());
    stmt.setString(3, ad.getDescription());
    stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    @Override
    public List<Ad> search(String term) {
        String sql = "SELECT * FROM ads WHERE title LIKE ?";
        String searchTermWithWildcards = "%" + term + "%";

        ResultSet rs;
        try  {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, searchTermWithWildcards);

            rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }

        return null;
    }

//    private String createInsertQuery(Ad ad) {
//        return "INSERT INTO ads(user_id, title, description) VALUES "
//            + "(" + ad.getUserId() + ", "
//            + "'" + ad.getTitle() +"', "
//            + "'" + ad.getDescription() + "')";
//    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }
}
