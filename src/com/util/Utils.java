package com.util;

import com.computer.hardware.part.keyboard.Qwerty;

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
    public static String deviceManager(){
        String input = new Scanner(System.in).nextLine();
        if(input.equals("keyboard connected")){
            return "k connected";
        }
        return "";
    }

}
