package com.computer.computer;

import com.computer.hardware.part.keyboard.Keyboard;
import com.computer.hardware.part.monitor.Monitor;
import com.computer.hardware.part.motherboard.MotherBoard;
import com.computer.hardware.part.networkcard.NetworkCard;
import com.computer.hardware.part.storage.RAM.RAM;
import com.computer.hardware.part.storage.ROM.ROM;
import com.computer.software.os.OS.Os;
import com.computer.hardware.part.processor.Processor;

import java.lang.reflect.Field;

public class ComputerBuilder {
    private Monitor monitor;
    private Keyboard keyboard;
    private final MotherBoard motherBoard;
    private NetworkCard NetworkCard;
    private final Os os;
    private final RAM ram;
    private final ROM rom;
    private final Processor processor;

    public ComputerBuilder(MotherBoard motherBoard, Os os, ROM rom, RAM ram, Processor processor) {
        this.rom = rom;
        this.os = os;
        this.motherBoard = motherBoard;
        this.ram = ram;
        this.processor = processor;
    }

    public ComputerBuilder setMonitor(Monitor monitor) {
        this.monitor = monitor;
        return this;
    }

    public ComputerBuilder setNetworkCard(NetworkCard networkCard) {
        this.NetworkCard = networkCard;
        return this;
    }

    public ComputerBuilder setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
        return this;
    }

    public Computer build() throws RuntimeException {
        String faultPart;
        if (motherBoard == null) {
            faultPart = "Motherboard";
        } else if (os ==  null) {
            faultPart = "OS";
        } else if (rom == null) {
            faultPart = "ROM";
        }else if (processor == null) {
            faultPart = "Processor";
        }else if (ram == null) {
            faultPart = "RAM";
        }else {
            for (Field field : this.getClass().getDeclaredFields()) {
                Object part;
                try {
                    part = field.get(this);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                if (part != null) {
                    this.motherBoard.addPart((ComputerParts) part);
                }
            }
            return new Computer(monitor, keyboard, motherBoard, NetworkCard, os, rom, ram, processor);
        }

        throw new RuntimeException(faultPart+" is missing!!!!");
    }
}

