/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thelinh.model;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Question {
    private String questionId;
    private String question;
    private String levels;
    private String subjectId;
    private int chapter;

    public Question(){
    
    }
    
    public Question(String questionId, String question, String levels, 
            String subjectId, int chapter) {
        this.questionId = questionId;
        this.question = question;
        this.levels = levels;
        this.subjectId = subjectId;
        this.chapter = chapter;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getLevels() {
        return levels;
    }

    public void setLevels(String levels) {
        this.levels = levels;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }
       
}

