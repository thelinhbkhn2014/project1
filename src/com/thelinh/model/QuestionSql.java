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
import java.util.ArrayList;
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
    
    public static ArrayList<Question> getRandomListQuestion(String subjectId, int chapter, String level, int quantity){
        ArrayList<Question> questionList = new ArrayList<>();
        try {
            PreparedStatement stmt = Connect.getConnect().prepareStatement(
                    "select * from questions where "
                            + "subjectid lIKE ? and levels LIKE ? and chapter = ?"
                            + "order by RANDOM() LIMIT ?");
            stmt.setString(1, subjectId.trim() + '%');
            stmt.setString(2, level);
            stmt.setInt(3, chapter);
            stmt.setInt(4, quantity);
            ResultSet res = stmt.executeQuery();
            Question q;
            while (res.next()) {
                q = new Question(res.getString("questionid").trim(),
                    res.getString("question"),
                    res.getString("levels"),
                    res.getString("subjectid").trim(),
                    res.getInt("chapter"));
                questionList.add(q);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
        return questionList;
    }
    
    public static ArrayList<Question> getAllQuestionBySubjectId(String subjectId) {
        ArrayList<Question> questionList = new ArrayList<>();
        try {
            PreparedStatement stmt = Connect.getConnect().prepareStatement(
                    "SELECT * FROM questions WHERE subjectid LIKE ?");
            stmt.setString(1, subjectId.trim() + "%");
            ResultSet res = stmt.executeQuery();
            Question question;
            //String questionId, String question, String levels, String subjectId, int chapter
            while (res.next()) {
                question = new Question(res.getString("questionid").trim(),
                    res.getString("question"),
                    res.getString("levels"),
                    res.getString("subjectid").trim(),
                    res.getInt("chapter"));
                questionList.add(question);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return questionList;
    }
    
    public static void main(String[] args) {
        ArrayList<Question> list = getAllQuestionBySubjectId("IT1110");
        for (Question q: list) {
            System.out.println(q.getQuestion());
        }
    }
}
