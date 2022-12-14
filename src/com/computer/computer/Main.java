package com.computer.computer;

import com.computer.hardware.part.keyboard.Keyboard;
import com.computer.hardware.part.keyboard.Qwerty;
import com.computer.hardware.part.monitor.Led;
import com.computer.hardware.part.monitor.Monitor;
import com.computer.hardware.part.motherboard.MicroAtxMotherBoard;
import com.computer.hardware.part.motherboard.MotherBoard;
import com.computer.hardware.part.networkcard.NetworkCard;
import com.computer.hardware.part.networkcard.Wired;
import com.computer.hardware.part.storage.RAM.RAM;
import com.computer.hardware.part.storage.ROM.ROM;
import com.computer.software.os.Mac;
import com.computer.software.os.Os;
import com.computer.hardware.part.processor.Intel;
import com.computer.hardware.part.processor.Processor;
import com.computer.hardware.part.storage.ROM.HDD;
import com.computer.hardware.part.storage.RAM.DDR3;
import com.util.Utils;

public class Main {

    public static void main(String[] args) {

        MotherBoard motherBoard = new MicroAtxMotherBoard("ASUS", "intel socket", 1000);
        Monitor monitor = new Led("Dell", "17 inch monitor", 1000);
        Keyboard keyboard = new Qwerty("mac", "Mechanical keyboard", 1000);
        NetworkCard nic = new Wired("mac", "parallel", 1000);
        Os os = new Mac("XP", "sdh", 1000, motherBoard);
        ROM rom = new HDD("seagate", "5TB", 1000);
        Processor processor = new Intel("intel", "dualCore", 1000);
        RAM ram = new DDR3("seagate", "5TB", 1000);

        Computer computer = null;

        if (motherBoard != null && os != null && rom != null && processor != null && ram != null) {
            computer = new ComputerBuilder(motherBoard, os, rom, ram, processor)
                    .setMonitor(monitor)
                    .setKeyboard(keyboard)
                    .setNetworkCard(nic)
                    .build();
        }
        if (computer == null) {
            System.out.println("no computer!!!");
        } else {
            System.out.println("1.Power On");
            if (Utils.getInteger() == 1) {
                System.out.print("Powering On");
                for(int i=0;i<4;i++){
                    try {
                        Thread.sleep(600);
                        System.out.print(".");
                    } catch (InterruptedException ignored) {

                    }
                }
                System.out.println("\n");
                computer.powerOn();
            } else {
                System.out.println("Shutting down.......");
            }
        }
    }
}
