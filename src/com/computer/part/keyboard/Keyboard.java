package com.computer.part.keyboard;

import com.computer.computer.ComputerParts;

import java.util.Scanner;

public abstract class Keyboard implements ComputerParts {
    public String getInput() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        return input;
    }

    @Override
    public String getCategory() {
        return "Keyboard";
    }
}