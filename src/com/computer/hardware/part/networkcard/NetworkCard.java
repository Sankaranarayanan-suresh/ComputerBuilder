package com.computer.hardware.part.networkcard;

import com.computer.computer.ComputerParts;

public abstract class NetworkCard implements ComputerParts {
    public abstract void toggleStatus();

    public abstract boolean status();


}
