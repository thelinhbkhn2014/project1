/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thelinh.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utils.Utils;

/**
 *
 * @author hoangkien
 */
public class ExamSql {

    public static boolean saveExam(Exam exam) {
        try {
            if (exam.getExamId() == 0) {
                // On create new Exam
                // Save exam header
                PreparedStatement stmt = Connect.getConnect().prepareStatement(
                        "INSERT INTO exams (subjectid, time, examcode) VALUES "
                                + "(?, ?, ?)",
                        Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, exam.getSubject().getSubjectId());
                stmt.setInt(2, exam.getTime());
                stmt.setString(3, exam.getExamCode());
                System.out.println(stmt);
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    exam.setExamId(rs.getInt(1));
                }
                // Save question of exam
                // ...
                for (Question q : exam.getQuestionList()) {
                    stmt = Connect.getConnect().prepareStatement(
                            "INSERT INTO examelem (examid, questionid) VALUES"
                                    + " (?, ?)",
                            Statement.RETURN_GENERATED_KEYS);
                    stmt.setInt(1, exam.getExamId());
                    stmt.setString(2, Utils.padRight(q.getQuestionId(), 10));
                    stmt.executeUpdate();
                }
            } else {
                // On update Exam
                PreparedStatement stmt = Connect.getConnect().prepareStatement(
                        "UPDATE exams SET subjectid = ?, time = ?, examcode = ? "
                        + "WHERE examid = ?");
                stmt.setString(1, exam.getSubject().getSubjectId());
                stmt.setInt(2, exam.getTime());
                stmt.setString(3, exam.getExamCode());
                stmt.setInt(4, exam.getExamId());
                stmt.executeUpdate();
                stmt = Connect.getConnect().prepareStatement(
                        "DELETE FROM examelem WHERE examid = ?");
                stmt.setInt(1, exam.getExamId());
                stmt.executeUpdate();
                for (Question q : exam.getQuestionList()) {
                    stmt = Connect.getConnect().prepareStatement(
                            "INSERT INTO examelem (examid, questionid) VALUES"
                                    + " (?, ?)",
                            Statement.RETURN_GENERATED_KEYS);
                    stmt.setInt(1, exam.getExamId());
                    stmt.setString(2, Utils.padRight(q.getQuestionId(), 10));
                    stmt.executeUpdate();
                }
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return false;
        }
        return true;
    }
    
    public static boolean deleteExam(Exam exam) {
        try {
            PreparedStatement stmt = Connect.getConnect().prepareStatement(
                "DELETE FROM exams WHERE examid = ?");
            stmt.setInt(1, exam.getExamId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return false;
        }
        
        return true;
    }

    public static ArrayList<Question> getAllQuestionInExam(Exam exam) {
        ArrayList<Question> questionList = new ArrayList<>();
        try {
            PreparedStatement stmt = Connect.getConnect().prepareStatement(
                    "SELECT questions.questionid AS qid, "
                    + "questions.question AS qs, "
                    + "questions.levels AS qlv, "
                    + "questions.subjectid AS qsubid, "
                    + "questions.chapter AS qchap "
                    + "FROM questions, examelem "
                    + "WHERE questions.questionid = examelem.questionid "
                    + "AND examelem.examid = ?");
            stmt.setInt(1, exam.getExamId());
            //System.out.println(stmt);
            stmt.setInt(1, exam.getExamId());
            ResultSet rs = stmt.executeQuery();
            Question q;
            while (rs.next()) {
                questionList.add(new Question(rs.getString("qid"), rs.getString("qs"),
                        rs.getString("qlv"), rs.getString("qsubid"),
                        rs.getInt("qchap")));
                
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return questionList;
    }

    public static ArrayList<Exam> getAllExamBySubject(Subject subject) {
        ArrayList<Exam> examList = new ArrayList<>();
        try {
            PreparedStatement stmt = Connect.getConnect().prepareStatement(
                    "SELECT * FROM exams WHERE subjectid LIKE ?");
            stmt.setString(1, Utils.padRight(subject.getSubjectId(), 10));
            ResultSet rs = stmt.executeQuery();
            Exam exam;
            while (rs.next()) {
                exam = new Exam();
                exam.setExamId(rs.getInt("examid"));
                exam.setExamCode(rs.getString("examcode"));
                exam.setSubject(subject);
                exam.setTime(rs.getInt("time"));
                exam.setQuestionList(getAllQuestionInExam(exam));
                examList.add(exam);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return examList;
    }
    
    public static Exam getExamByExamId(int examId) {
        Exam exam = new Exam();
        try {
            PreparedStatement stmt = Connect.getConnect().prepareStatement(
                "SELECT * FROM exams WHERE examid = ?");
            stmt.setInt(1, examId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                exam.setExamId(examId);
                exam.setExamCode(rs.getString("examcode"));
                exam.setSubject(SubjectSql.getSubjectById(rs.getString("subjectid")));
                exam.setTime(rs.getInt("time"));
                exam.setQuestionList(getAllQuestionInExam(exam));
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return exam;
    }

    public static void main(String[] args) {
        System.out.println(getExamByExamId(1).getQuestionList().get(0).getQuestion());
    }
}
