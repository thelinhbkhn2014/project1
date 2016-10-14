/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thelinh.controller;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Result {
    private String userId;
    private Date testDay;
    private String subjectId;
    private float result;

    public Result(String userId, Date testDay, String subjectId, float result) {
        this.userId = userId;
        this.testDay = testDay;
        this.subjectId = subjectId;
        this.result = result;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getTestDay() {
        return testDay;
    }

    public void setTestDay(Date testDay) {
        this.testDay = testDay;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public float getResult() {
        return result;
    }

    public void setResult(float result) {
        this.result = result;
    }
    
    
}
