package com.computer.computer;

import com.computer.hardware.part.keyboard.Keyboard;
import com.computer.hardware.part.monitor.Monitor;
import com.computer.hardware.part.motherboard.MotherBoard;
import com.computer.hardware.part.networkcard.NetworkCard;
import com.computer.hardware.part.processor.Processor;
import com.computer.hardware.part.storage.RAM.RAM;
import com.computer.hardware.part.storage.ROM.ROM;
import com.computer.software.os.OS.Os;

public class Computer {
    private final Monitor monitor;
    private final Keyboard keyboards;
    private final MotherBoard motherBoard;
    private final NetworkCard networkCard;
    private final Os os;
    private final RAM ram;
    private final ROM rom;
    private final Processor processor;

    public Computer(Monitor monitor, Keyboard keyboards, MotherBoard motherBoard, NetworkCard networkCard, Os os,
                    ROM rom, RAM ram, Processor processor) {
        this.monitor = monitor;
        this.keyboards = keyboards;
        this.motherBoard = motherBoard;
        this.networkCard = networkCard;
        this.os = os;
        this.rom = rom;
        this.ram = ram;
        this.processor = processor;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "monitor=" + monitor.getName() + monitor.getConfig()+
                "\nkeyboards=" + keyboards.getName()+ keyboards.getConfig() +
                "\nmotherBoard=" +motherBoard.getName()+ motherBoard.getConfig() +
                "\nnetworkCard=" + networkCard.getName()+networkCard.getConfig() +
                "\nos=" + os.getName()+os.getConfig() +
                "\nram=" + ram.getName()+ram.getConfig() +
                "\nrom=" + rom.getName()+rom.getConfig() +
                "\nprocessor="+ processor.getName()+processor.getConfig()+
                '}';
    }

    public void powerOn() {
        motherBoard.biosBoot();
        os.driverFunction();
    }
}
