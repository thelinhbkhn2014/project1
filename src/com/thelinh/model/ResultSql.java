/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thelinh.model;

import com.thelinh.controller.Result;
import java.sql.Date;
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
public class ResultSql {
    private static PreparedStatement ps;
    private static ResultSet rs;
    
    public static void insertResult(Result r){
        String sql = "INSERT INTO Results VALUES(?,?,?,?)";
        
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            ps.setString(1, r.getUserId());
            ps.setDate(2, r.getTestDay());
            ps.setString(3, r.getSubjectId());
            ps.setFloat(4, r.getResult());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Add Successful", "Notification", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: Unsucessful", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
    public static boolean updateResult(Result r){
        String sql = "UPDATE Results SET Result = ? WHERE UserId = ? AND TestDay = ? AND SubjectId = ?";
         
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            ps.setFloat(1, r.getResult());
            ps.setString(2, r.getUserId());
            ps.setDate(3, r.getTestDay());
            ps.setString(4, r.getSubjectId());
            return ps.executeUpdate() > 0;
                    
        } catch (SQLException ex) {
            return false;
        }
        
    }
    
    public static boolean deleteResult(String userId, Date testDay, String subjectId){
        String sql = "DELETE FROM Results WHERE UserId = ? AND TestDay = ? AND SubjectId = ?";
        
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            ps.setString(1, userId);
            ps.setDate(2, testDay);
            ps.setString(3, subjectId);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
        
    }
    
}
