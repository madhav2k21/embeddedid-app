package com.techleads.app.service;

import jdk.swing.interop.SwingInterOpUtils;

public class CamelCaseTest {
    public static void main(String[] args) {
        String madhav = toCamelCase("madhav");
        System.out.println(madhav);
    }

    private static String toCamelCase(String value) {
        if (value == null) {
            return value;
        }
        if (value.trim().length() == 1) {
            return value.toUpperCase();
        }
        return value.substring(0, 1).toUpperCase() + value.substring(1).toLowerCase();
    }
}
