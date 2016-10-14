/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thelinh.model;

import com.thelinh.controller.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class UserSql {
    private static PreparedStatement ps;
    private static ResultSet rs;
    
    public static User signIn(String userId, String password){
        User user = null;
        String sql = "SELECT * FROM Users WHERE UserId = ? AND Password = ?";
        
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            ps.setString(1, userId);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while(rs.next()){
                user = new User(userId, password, rs.getString("UserName"), rs.getDate("BirthDay"));
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR");
        }
        
        return user;
    }
    
    public static void insertUser(User user){
        String sql = "INSERT INTO Users VALUES (?,?,?,?)";
        
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            ps.setString(1, user.getUserId());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getUserName());
            ps.setDate(4, user.getBirthDay());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Add Successful", "Notification", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: Unsuccessfull", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public static boolean updateUser(User user){
        String sql = "UPDATE User SET Password = ?, UserName = ?, BirthDay = ? WHERE UserId = ?";
        
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            ps.setString(1, user.getPassword());
            ps.setString(2, user.getUserName());
            ps.setDate(3, user.getBirthDay());
            ps.setString(4, user.getUserId());
            return ps.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            return false;
        }
        
    }
    
    public static boolean deleteUser(String userId){
        String sql = "DELETE FROM Users WHERE UserId = ?";
        
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            ps.setString(1, userId);
            return ps.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            return false;
        }
        
        
    }
    
    
    
    
}
