/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thelinh.controller;

/**
 *
 * @author Admin
 */
public class Answer {
    private String questionId;
    private String answer;
    private boolean yesNo;
    private int number;

    public Answer(String questionId, String answer, boolean yesNo,int number) {
        this.questionId = questionId;
        this.answer = answer;
        this.yesNo = yesNo;
        this.number = number;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean getYesNo() {
        return yesNo;
    }

    public void setYesNo(boolean yesNo) {
        this.yesNo = yesNo;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    
    
}
