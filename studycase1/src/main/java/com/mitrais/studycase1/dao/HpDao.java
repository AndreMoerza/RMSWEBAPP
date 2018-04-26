/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitrais.studycase1.dao;
import java.sql.*;
import java.util.*;
import com.mitrais.studycase1.model.Handphone;
import com.mitrais.studycase1.util.Database;
/**
 *
 * @author Andre_P772
 */
public class HpDao {
    private Connection connection;
 
    public HpDao() {
        connection = Database.getConnection();
    }
    
    public void checkHp(Handphone hp) {
        try {
            PreparedStatement ps = connection.prepareStatement("select hp_name from handphone where hp_id = ?");
            ps.setString(1, hp.gethp_id());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {
                updateHp(hp);
            } else {
                addHp(hp);
            }
        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        } 
    }
    public void addHp(Handphone hp) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into handphone(hp_id, hp_name, hp_type, hp_prod_date) values (?, ?, ?, ? )");
            // Parameters start with 1
            preparedStatement.setString(1, hp.gethp_id());
            preparedStatement.setString(2, hp.gethp_name());
            preparedStatement.setString(3, hp.gethp_type());            
            preparedStatement.setDate(4, new java.sql.Date(hp.gethp_prod_date().getTime()));
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public void deleteHp(String hp_id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from handphone where hp_id=?");
            // Parameters start with 1
            preparedStatement.setString(1, hp_id);
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public void updateHp(Handphone hp) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update handphone set hp_name=?, hp_type=?, hp_prod_date=?"
                    + "where hp_id=?");
            // Parameters start with 1
            System.out.println(new java.sql.Date(hp.gethp_prod_date().getTime()));
            preparedStatement.setString(1, hp.gethp_name());
            preparedStatement.setString(2, hp.gethp_type());
            preparedStatement.setDate(3, new java.sql.Date(hp.gethp_prod_date().getTime()));
            preparedStatement.setString(4, hp.gethp_id());
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public List<Handphone> getAllHps() {
        List<Handphone> hps = new ArrayList<Handphone>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from handphone");
            while (rs.next()) {
                Handphone hp = new Handphone();
                hp.sethp_id(rs.getString("hp_id"));
                hp.sethp_name(rs.getString("hp_name"));
                hp.sethp_type(rs.getString("hp_type"));
                hp.sethp_prod_date(rs.getDate("hp_prod_date"));
                hps.add(hp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return hps;
    }
 
    public Handphone getHpById(String hp_id) {
        Handphone hp = new Handphone();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from handphone where hp_id=?");
            preparedStatement.setString(1, hp_id);
            ResultSet rs = preparedStatement.executeQuery();
 
            if (rs.next()) {
                hp.sethp_id(rs.getString("hp_id"));
                hp.sethp_name(rs.getString("hp_name"));
                hp.sethp_type(rs.getString("hp_type"));
                hp.sethp_prod_date(rs.getDate("hp_prod_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return hp;
    }
}
