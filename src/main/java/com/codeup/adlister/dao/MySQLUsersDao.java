package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.sql.*;

public class MySQLUsersDao extends Users{
    private Connection connection = null;

    @Override
    public Long insert(User user) {
//        connection
//                driver in try catch
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO ads(user_id, title, description) VALUES(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
//            stmt.executeUpdate(createInsertQuery(ad), Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, user.getUserId());
            stmt.setString(2, user.getTitle());
            stmt.setString(3, user.getDescription());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);

        } catch  (SQLException e){
            throw new RuntimeException("Error in creating new ad.", e)
        }
        return null;
    }

    @Override
    public User findByUserName(String username){
        String query = "select  from users where usernmae = ? limit 1"

        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO ads(user_id, title, description) VALUES(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
//            stmt.executeUpdate(createInsertQuery(ad), Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, username);
            stmt.executeQuery();

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return new User(
                    rs.getLong("id"),
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("password")


            );
//            ResultSet rs = stmt.getGeneratedKeys();
//            rs.next();

//            return rs.getLong(1);

        } catch  (SQLException e){
            throw new RuntimeException("Error in creating new ad.", e)
        }

        return null;
    }
}
