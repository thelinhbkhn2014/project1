/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thelinh.controller;

import com.thelinh.model.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class LoadTable {
    public static void loadDataAnswer(String sql, JTable table){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = Connect.getConnect();
        DefaultTableModel tableModel = new DefaultTableModel();
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            ResultSetMetaData metaData = rs.getMetaData();
            int numberColumn = metaData.getColumnCount();
            
            ArrayList arrayColumn = new ArrayList();
            
            for(int i = 1; i <= numberColumn; i++){
                arrayColumn.add(metaData.getColumnName(i));
            }
            
            tableModel.setColumnIdentifiers(arrayColumn.toArray());
            
            ArrayList arrayRow = new ArrayList();
            while(rs.next()){                
                arrayRow.add(rs.getString("QuestionId"));
                arrayRow.add(rs.getString("Answer"));
                arrayRow.add(rs.getBoolean("YesNo"));
                arrayRow.add(rs.getInt("Number"));
        
                tableModel.addRow(arrayRow.toArray());
                arrayRow.clear();
            }
            table.setModel(tableModel);
            rs.close();
            ps.close();
            
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public static void loadDataChap(String sql, JTable table){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = Connect.getConnect();
        DefaultTableModel tableModel = new DefaultTableModel();
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            ResultSetMetaData metaData = rs.getMetaData();
            int numberColumn = metaData.getColumnCount();
            
            ArrayList arrayColumn = new ArrayList();
            
            for(int i = 1; i <= numberColumn; i++){
                arrayColumn.add(metaData.getColumnName(i));
            }
            
            tableModel.setColumnIdentifiers(arrayColumn.toArray());
            
            ArrayList arrayRow = new ArrayList();
            while(rs.next()){                
                arrayRow.add(rs.getString("SubjectId"));
                arrayRow.add(rs.getInt("Chapter"));
                arrayRow.add(rs.getString("ChapterName"));
                
        
                tableModel.addRow(arrayRow.toArray());
                arrayRow.clear();
            }
            table.setModel(tableModel);
            rs.close();
            ps.close();
            
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public static void loadDataQuestion(String sql, JTable table){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = Connect.getConnect();
        DefaultTableModel tableModel = new DefaultTableModel();
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            ResultSetMetaData metaData = rs.getMetaData();
            int numberColumn = metaData.getColumnCount();
            
            ArrayList arrayColumn = new ArrayList();
            
            for(int i = 1; i <= numberColumn; i++){
                arrayColumn.add(metaData.getColumnName(i));
            }
            
            tableModel.setColumnIdentifiers(arrayColumn.toArray());
            
            ArrayList arrayRow = new ArrayList();
            while(rs.next()){                
                arrayRow.add(rs.getString("QuestionId"));
                arrayRow.add(rs.getString("Question"));
                arrayRow.add(rs.getString("Levels"));
                arrayRow.add(rs.getString("SubjectId"));
                arrayRow.add(rs.getInt("Chapter"));
        
                tableModel.addRow(arrayRow.toArray());
                arrayRow.clear();
            }
            table.setModel(tableModel);
            rs.close();
            ps.close();
            
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    
}
