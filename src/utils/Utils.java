/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author hoangkien
 */
public class Utils {
    public static String padRight(String s, int n) {
        return String.format("%1$-" + n + "s", s);
    }
}
