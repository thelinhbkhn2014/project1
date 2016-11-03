/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thelinh.model;

import com.thelinh.model.Question;
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
public class QuestionSql {
    private static PreparedStatement ps;
    private static ResultSet rs;
    
    public static void insertQuestion(Question qt){
        String sql = "INSERT INTO Questions VALUES(?,?,?,?,?)";
        
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            ps.setString(1, qt.getQuestionId());
            ps.setString(2, qt.getQuestion());
            ps.setString(3, qt.getLevels());
            ps.setString(4, qt.getSubjectId());
            ps.setInt(5, qt.getChapter());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Add Successful", "Notification", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: Unsuccessful", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
    public static boolean updateQuestion(Question qt){
        String sql = "UPDATE Questions SET Question = ?, Levels = ?, SubjectId = ?, Chapter = ? WHERE QuestionId = ?";
        
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            ps = Connect.getConnect().prepareStatement(sql);
            ps.setString(1, qt.getQuestion());
            ps.setString(2, qt.getLevels());
            ps.setString(3, qt.getSubjectId());
            ps.setInt(4, qt.getChapter());
            ps.setString(5, qt.getQuestionId());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public static boolean deleteQuestion(String questionId){
        String sql = "DELERE FROM Questions WHERE QuestionId = ?";
        
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            ps.setString(1, questionId);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
        
    }
    
}
