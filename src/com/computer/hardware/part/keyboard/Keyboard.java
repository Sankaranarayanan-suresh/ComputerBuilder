package com.computer.hardware.part.keyboard;

import com.computer.computer.ComputerParts;

import java.util.Scanner;

public abstract class Keyboard implements ComputerParts {
    public String getInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
