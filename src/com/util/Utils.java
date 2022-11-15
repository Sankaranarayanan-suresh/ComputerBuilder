package com.util;

import java.util.Scanner;

public class Utils {
    public static int getInteger() {
        Scanner sc = new Scanner(System.in);
        try {
            return sc.nextInt();
        } catch (Exception e) {
            System.out.println("Enter correct option!!!.");
            return getInteger();
        }
    }

}
