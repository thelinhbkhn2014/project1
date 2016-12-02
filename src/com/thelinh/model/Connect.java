/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thelinh.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class Connect {

    private static Connection conn;

    public static Connection getConnect() {
        if (conn == null) {
            try (BufferedReader br = new BufferedReader(new FileReader("config.conf"))) {
                String user;
                user = br.readLine();
                if (user == null) {
                    JOptionPane.showMessageDialog(null, "Missing user in config.conf");
                    return null;
                }
                String password;
                password = br.readLine();
                if (password == null) {
                    JOptionPane.showMessageDialog(null, "Missing password in config.conf");
                    return null;
                }
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/XayDungVaQuanLyDeThiTracNghiem", user, password);
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }
        return conn;
    }
}
