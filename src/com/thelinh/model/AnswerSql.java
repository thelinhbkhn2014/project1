/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thelinh.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import utils.Utils;

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
    public static boolean deleteAnswer(String questionId, int number){
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
    
    public static ArrayList<Answer> getAnswersByQuestionId(String questionId){
        ArrayList<Answer> answerList = new ArrayList<>();
        try {
            PreparedStatement stmt = Connect.getConnect().prepareStatement(
                    "SELECT * FROM answers WHERE questionid LIKE ?");
            stmt.setString(1, Utils.padRight(questionId, 10));
            ResultSet res = stmt.executeQuery();
            Answer answer;
            while (res.next()) {
                // String questionId, String answer, boolean yesNo, int number
                boolean yesNo = true;
                if (res.getString("yesno").equals("false")) {
                    yesNo = false;
                }
                answer = new Answer(questionId, res.getString("answer"), yesNo, 
                    res.getInt("number"));
                answerList.add(answer);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
        return answerList;
    }
    
    public static void main(String[] args) {
        ArrayList<Answer> list = getAnswersByQuestionId("1");
        for (Answer an: list) {
            System.out.println(an.getNumber() + " " + an.getAnswer() + " " + an.getYesNo());
        }
    }
}
