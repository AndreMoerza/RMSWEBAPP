package com.mitrais.studycase1.dao;

import com.mitrais.studycase1.util.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mitrais.studycase1.model.User;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Andre_P772
 */
public class UserDao {
    private Connection connection;
    
    public UserDao()
    {
        connection = Database.getConnection();
    }
    
    public boolean checkUser(String uname, String pass)
    {
        try {
            PreparedStatement ps = connection.prepareStatement("select * from users where uname = ? and password = ?");
            ps.setString(1, uname);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                return true;
            } 
        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        } 
        
        return false;
    }
    
    public void addUser(User user) throws SQLException
    {
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("insert into users(uname, password, email, registerdate) values (?, ?, ?, ? )");
            // Parameters start with 1
            preparedStatement.setString(1, user.getuname());
            preparedStatement.setString(2, user.getpassword());
            preparedStatement.setString(3, user.getemail());            
            preparedStatement.setDate(4, new java.sql.Date(user.getregisterdate().getTime()));
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        }
    }
    
    public void updateUser(User user) throws SQLException
    {
         try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("update users set password=?, email=?, registerdate=?"
                    + "where uname=?");
            System.out.println(new java.sql.Date(user.getregisterdate().getTime()));
            preparedStatement.setString(1, user.getpassword());
            preparedStatement.setString(2, user.getemail());
            preparedStatement.setDate(3, new java.sql.Date(user.getregisterdate().getTime()));
            preparedStatement.setString(4, user.getuname());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        }
    }
    
    public void deleteUser(String userId) throws SQLException
    {
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("delete from users where uname=?");
            preparedStatement.setString(1, userId);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        }
    }
    
     public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from users");
            while (rs.next()) {
                User user = new User();
                user.setuname(rs.getString("uname"));
                user.setpassword(rs.getString("password"));
                user.setemail(rs.getString("email"));
                user.setregisterdate(rs.getDate("registerdate"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return users;
    }
 
    public User getUserById(String userId) {
        User user = new User();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where uname=?");
            preparedStatement.setString(1, userId);
            ResultSet rs = preparedStatement.executeQuery();
 
            if (rs.next()) {
                user.setuname(rs.getString("uname"));
                user.setpassword(rs.getString("password"));
                user.setemail(rs.getString("email"));
                user.setregisterdate(rs.getDate("registerdate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return user;
    }
}
