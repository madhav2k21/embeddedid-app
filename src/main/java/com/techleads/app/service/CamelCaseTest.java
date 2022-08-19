package com.techleads.app.service;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Objects;

public class CamelCaseTest {
    public static void main(String[] args) {


        String test="d";
        if(Objects.nonNull(test)&&test.length()>0) {
            String[] name = test.split("\\s+");


            if (name.length == 2) {
                String firstName = toCamelCase(name[0]);
                String lastName = toCamelCase(name[1]);
                System.out.println(firstName + " " + lastName);
            } else if (name.length == 1) {
                String firstName = toCamelCase(name[0]);
                System.out.println(firstName);
            }
            System.out.println(name.length);
        }
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
