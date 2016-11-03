/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thelinh.model;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Test {
    private String testId;
    private String subjectId;
    private Date testDay;
    private String adminId;
    private String questionId;

    public Test(String testId, String subjectId, Date testDay, String adminId, String questionId) {
        this.testId = testId;
        this.subjectId = subjectId;
        this.testDay = testDay;
        this.adminId = adminId;
        this.questionId = questionId;
    }

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public Date getTestDay() {
        return testDay;
    }

    public void setTestDay(Date testDay) {
        this.testDay = testDay;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }
    
    
            
}
