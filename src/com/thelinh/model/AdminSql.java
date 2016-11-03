/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thelinh.model;

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
public class AdminSql {
    private static PreparedStatement ps;
    private static ResultSet rs;
    
    public static Admin signIn(String adminId,String password){
        Admin ad = null;
        String sql = "SELECT * FROM Admins WHERE AdminId = ? AND Password = ?";
        
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            ps.setString(1, adminId);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while(rs.next()){
                ad = new Admin(adminId, password, rs.getString("AdminName"));
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR");
        }
        
        return ad;
    }
    
    
}
