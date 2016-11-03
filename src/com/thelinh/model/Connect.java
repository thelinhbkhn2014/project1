/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thelinh.model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Admin
 */
public class Connect {

    private static Connection conn;

    public static Connection getConnect() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/XayDungVaQuanLyDeThiTracNghiem", "postgres", "1234");
        } catch (Exception ee) {
            ee.printStackTrace();
        }
        return conn;
    }
    public static void main(String[] args) {
        if (Connect.getConnect() == null) {
            System.out.println("Null");
        }
    }
}
