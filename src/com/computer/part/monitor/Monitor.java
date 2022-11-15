package com.computer.part.monitor;

import com.computer.computer.ComputerParts;

public abstract class Monitor implements ComputerParts {
    @Override
    public String getCategory() {
        return "Monitor";
    }

    public void display(String message) {
        System.out.println(message);
    }
}
