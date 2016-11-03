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
public class TestSql {
    private static PreparedStatement ps;
    private static ResultSet rs;
    
    public static void insertTest(Test test){
        String sql = "INSERT INTO Tests VALUES(?,?,?,?,?)";
        
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            ps.setString(1, test.getTestId());
            ps.setString(2, test.getSubjectId());
            ps.setDate(3, test.getTestDay());
            ps.setString(4, test.getAdminId());
            ps.setString(5, test.getQuestionId());
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Add Successful", "Notification", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: Unsuccessfull", "ERROR", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        
    }
    
    public static boolean updateTest(Test test){
        String sql = "UPDATE Tests SET SubjectId = ?, TestDay = ?, AdminId = ?, QuestionId = ? WHERE TestId = ?";
        
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            ps.setString(1, test.getSubjectId());
            ps.setDate(2, test.getTestDay());
            ps.setString(3, test.getAdminId());
            ps.setString(4, test.getQuestionId());
            ps.setString(5, test.getTestId());
            return ps.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            return false;
        }
        
        
    }
    
    public static boolean deleteTest(String testId){
        String sql = "DELETE FROM Tests WHERE TestId = ?";
        
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            ps.setString(1, testId);
            return ps.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            return false;
        }
        
    }
    
    
    
}
