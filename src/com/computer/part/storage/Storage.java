package com.computer.part.storage;

import com.computer.computer.ComputerParts;

public abstract class Storage implements ComputerParts {
    @Override
    public String getCategory() {
        return "Storage";
    }
}
