/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thelinh.model;

import com.thelinh.model.Answer;
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
public class AnswerSql {
    private static PreparedStatement ps;
    private static ResultSet rs;
    
    public static void insertAnswer(Answer as){
        String sql = "INSERT INTO Answers VALUES(?,?,?,?)";
        
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            ps.setString(1, as.getQuestionId());
            ps.setString(2, as.getAnswer());
            ps.setBoolean(3, as.getYesNo());
            ps.setInt(4, as.getNumber());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Add Successful", "Notification", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: Unsuccessful", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public static boolean updateAnswer(Answer as){
        String sql = "UPDATE Answers SET Answer = ?, YesNo = ? WHERE QuestionId = ? AND Number = ?";
        
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            ps.setString(1, as.getAnswer());
            ps.setBoolean(2, as.getYesNo());
            ps.setString(3, as.getQuestionId());
            ps.setInt(4, as.getNumber());
            return ps.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            return false;
        }
        
    }
    //Phai viet lai database
    public static boolean deleteAnswer(String questionId,int number){
        String sql = "DELETE FROM Answers WHERE QuestionId = ? AND Number = ?";
        
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            ps.setString(1, questionId);
            ps.setInt(2, number);
            return ps.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            return false;
        }
        
       
    }
    
}
