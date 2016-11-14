/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thelinh.model;

import com.thelinh.controller.Controller;
import com.thelinh.model.Result;
import java.sql.Date;
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
public class ResultSql {

    public static boolean saveResult(Result result) {
        try {
            PreparedStatement stmt = Connect.getConnect().prepareStatement(
                    "INSERT INTO results (userid, examid, result, date) VALUES (?,?,?,?)");
            stmt.setString(1, Utils.padRight(result.getUser().getUserId(), 10));
            stmt.setInt(2, result.getExam().getExamId());
            stmt.setFloat(3, result.getResult());
            stmt.setDate(4, new java.sql.Date(result.getDate().getTime()));
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return true;
    }

    public static ArrayList<Result> getAllResultByUser(User user) {
        ArrayList<Result> list = new ArrayList<>();
        try {
            PreparedStatement stmt = Connect.getConnect().prepareStatement(
                    "select results.resultid AS rid, results.userid AS uid, "
                    + "exams.examid AS eid, "
                    + "results.date AS date, results.result AS mark "
                    + "from results, subjects, exams "
                    + "where results.examid = exams.examid and "
                    + "exams.subjectid = subjects.subjectid "
                    + "and results.userid = ?;");
            stmt.setString(1, user.getUserId().trim());
            ResultSet rs = stmt.executeQuery();
            Result result;
            while (rs.next()) {
                result = new Result();
                result.setResultId(rs.getInt("rid"));
                result.setDate(rs.getDate("date"));
                result.setExam(ExamSql.getExamByExamId(rs.getInt("eid")));
                result.setResult(rs.getFloat("mark"));
                result.setUser(user);
                list.add(result);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return list;
    }
    public static void main(String[] args) {
        User user = Controller.signInUser("hk", "1");
        ArrayList<Result> list =  getAllResultByUser(user);
        for (Result r: list) {
            System.out.println(r.getDate());
            System.out.println(r.getExam().getExamCode());
            System.out.println(r.getResult());
            System.out.println(r.getUser().getUserId());
        }
    }
}
