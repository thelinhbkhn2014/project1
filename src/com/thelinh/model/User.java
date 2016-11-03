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
public class User {
    private String userId;
    private String password;
    private String userName;
    private Date birthDay;
    private String classs;

    public User(String userId, String password, String userName, Date birthDay,String classs) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.birthDay = birthDay;
        this.classs = classs;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getClasss() {
        return classs;
    }

    public void setClasss(String classs) {
        this.classs = classs;
    }
    
    
    
    
}
