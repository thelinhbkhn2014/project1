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

    public static void loadDataAnswer(String sql, JTable table) {
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

            for (int i = 1; i <= numberColumn; i++) {
                arrayColumn.add(metaData.getColumnName(i));
            }

            tableModel.setColumnIdentifiers(arrayColumn.toArray());

            ArrayList arrayRow = new ArrayList();
            while (rs.next()) {
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

    public static void loadDataChap(String sql, JTable table) {
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

            for (int i = 1; i <= numberColumn; i++) {
                arrayColumn.add(metaData.getColumnName(i));
            }

            tableModel.setColumnIdentifiers(arrayColumn.toArray());

            ArrayList arrayRow = new ArrayList();
            while (rs.next()) {
                arrayRow.add(rs.getString("SubjectId"));
                arrayRow.add(rs.getString("SubjectName"));              
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
            ex.printStackTrace();
        }

    }

    public static void loadDataQuestion(String sql, JTable table) {
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

            for (int i = 1; i <= numberColumn; i++) {
                arrayColumn.add(metaData.getColumnName(i));
            }

            tableModel.setColumnIdentifiers(arrayColumn.toArray());

            ArrayList arrayRow = new ArrayList();
            while (rs.next()) {
                arrayRow.add(rs.getString("QuestionId"));
                arrayRow.add(rs.getString("Question"));
                arrayRow.add(rs.getString("Levels"));
                arrayRow.add(rs.getString("SubjectId"));
                arrayRow.add(rs.getString("Chapter"));
                arrayRow.add(rs.getInt("Number"));
                arrayRow.add(rs.getString("Answer"));
                arrayRow.add(rs.getBoolean("YesNo"));

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

    public static void loadDataQuestions(String sql, JTable table) {
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

            for (int i = 1; i <= numberColumn; i++) {
                arrayColumn.add(metaData.getColumnName(i));
            }

            tableModel.setColumnIdentifiers(arrayColumn.toArray());

            ArrayList arrayRow = new ArrayList();
            while (rs.next()) {
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

    public static void loadDataResult(String sql, JTable table) {
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

            for (int i = 1; i <= numberColumn; i++) {
                arrayColumn.add(metaData.getColumnName(i));
            }

            tableModel.setColumnIdentifiers(arrayColumn.toArray());

            ArrayList arrayRow = new ArrayList();
            while (rs.next()) {
                arrayRow.add(rs.getString("UserId"));
                arrayRow.add(rs.getDate("TestDay"));
                arrayRow.add(rs.getString("SubjectId"));
                arrayRow.add(rs.getFloat("Result"));

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

    public static void loadDataSubject(String sql, JTable table) {
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

            for (int i = 1; i <= numberColumn; i++) {
                arrayColumn.add(metaData.getColumnName(i));
            }

            tableModel.setColumnIdentifiers(arrayColumn.toArray());

            ArrayList arrayRow = new ArrayList();
            while (rs.next()) {
                arrayRow.add(rs.getString("SubjectId"));
                arrayRow.add(rs.getString("SubjectName"));

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

    public static void loadDataUser(String sql, JTable table) {
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

            for (int i = 1; i <= numberColumn; i++) {
                arrayColumn.add(metaData.getColumnName(i));
            }

            tableModel.setColumnIdentifiers(arrayColumn.toArray());

            ArrayList arrayRow = new ArrayList();
            while (rs.next()) {
                arrayRow.add(rs.getString("UserId"));
                arrayRow.add(rs.getString("Password"));
                arrayRow.add(rs.getString("UserName"));
                arrayRow.add(rs.getDate("BirthDay"));
                arrayRow.add(rs.getString("Class"));

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

    public static ResultSet Display(String sql) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = Connect.getConnect();
        try {
            //System.out.println(sql);
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return null;
        }
    }

}
