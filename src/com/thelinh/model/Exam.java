/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thelinh.model;

import java.util.ArrayList;

/**
 *
 * @author hoangkien
 */
public class Exam {
    private int examId;
    private Subject subject;
    private int time; // In minutes
    private ArrayList<Question> questionList;
    private String examCode;

    public Exam() {
        this.examId = 0;
        this.subject = null;
        this.time = 0;
        this.questionList = null;
        this.examCode = null;
    }

    public Exam(int examId, Subject subject, int time, 
            ArrayList<Question> questionList, String examCode) {
        this.examId = examId;
        this.subject = subject;
        this.time = time;
        this.questionList = questionList;
        this.examCode = examCode;
    }
    
    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }
    
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public ArrayList<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(ArrayList<Question> questionList) {
        this.questionList = questionList;
    }

    public String getExamCode() {
        return examCode;
    }

    public void setExamCode(String examCode) {
        this.examCode = examCode;
    }
    
}
