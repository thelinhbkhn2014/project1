/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thelinh.model;

import com.thelinh.controller.Subject;
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
public class SubjectSql {
    private static PreparedStatement ps;
    private static ResultSet rs;
    
    public static void insertSubject(Subject sj){
        String sql = "INSERT INTO Subjects VALUES(?,?)";
        
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            ps.setString(1, sj.getSubjectId());
            ps.setString(2, sj.getSubjectName());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Add Successful", "Notification", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: Unsucessful", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public static boolean updateSubject(Subject sj){
        String sql = "UPDATE Subjects SET SubjectName = ? WHERE SubjectId = ?";
        
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            ps.setString(1, sj.getSubjectName());
            ps.setString(2, sj.getSubjectId());
            return ps.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            return false;
        }
        
    }
    
    public static boolean deleteSubject(String subjectId){
        String sql = "DELETE FROM Subjects WHERE SubjectId = ?";
        
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            ps.setString(1, subjectId);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
        
    }
    
}
