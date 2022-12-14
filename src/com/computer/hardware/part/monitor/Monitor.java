package com.computer.hardware.part.monitor;

import com.computer.computer.ComputerParts;

public abstract class Monitor implements ComputerParts {
    public void display(String message) {
        System.out.println(message);
    }
}
