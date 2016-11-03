/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thelinh.model;

import com.thelinh.model.Chap;
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
public class ChapSql {
    private static PreparedStatement ps;
    private static ResultSet rs;
    
    public static void insertChap(Chap c){
        String sql = "INSERT INTO Chaps VALUES(?,?,?)";
        
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            ps.setString(1, c.getSubjectId());
            ps.setInt(2, c.getChapter());
            ps.setString(3, c.getChapterName());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Add Successful", "Notification", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: Unsuccessful", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public static boolean updateChap(Chap c){
        String sql = "UPDATE Chaps SET ChapterName = ? WHERE SubjectId = ? AND Chapter = ?";
        
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            ps.setString(1, c.getChapterName());
            ps.setString(2, c.getSubjectId());
            ps.setInt(3, c.getChapter());
            return ps.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public static boolean deleteChap(String subjectId, int chapter){
        String sql = "DELETE FROM Chaps WHERE SubjectId = ? AND Chapter = ?";
        
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            ps.setString(1, subjectId);
            ps.setInt(2, chapter);
            return ps.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            return false;
        }
        
        
    }
    
}
