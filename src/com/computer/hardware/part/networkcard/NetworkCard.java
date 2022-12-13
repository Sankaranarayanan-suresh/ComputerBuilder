package com.computer.hardware.part.networkcard;

import com.computer.computer.ComputerParts;

public abstract class NetworkCard implements ComputerParts {
    @Override
    public String getCategory() {
        return "Network card";
    }

    public abstract void updateStatus();

    public abstract boolean status();

}
