package com.computer.computer;

import com.computer.hardware.part.keyboard.Keyboard;
import com.computer.hardware.part.keyboard.Qwerty;
import com.computer.hardware.part.monitor.Led;
import com.computer.hardware.part.monitor.Monitor;
import com.computer.hardware.part.motherboard.MicroAtxMotherBoard;
import com.computer.hardware.part.motherboard.MotherBoard;
import com.computer.hardware.part.networkcard.NetworkCard;
import com.computer.hardware.part.networkcard.Wired;
import com.computer.software.os.Mac;
import com.computer.software.os.Os;
import com.computer.hardware.part.processor.Intel;
import com.computer.hardware.part.processor.Processor;
import com.computer.hardware.part.storage.ROM.HDD;
import com.computer.hardware.part.storage.RAM.DDR3;
import com.computer.hardware.part.storage.Storage;
import com.util.Utils;

public class Main {

    public static void main(String[] args) {

        MotherBoard motherBoard = new MicroAtxMotherBoard("ASUS", "intel socket", 1000);
        Monitor monitor = new Led("Dell", "17 inch monitor", 1000);
        Keyboard keyboard = new Qwerty("mac", "Mechanical keyboard", 1000);
        NetworkCard nic = new Wired("mac", "parallel", 1000);
        Os os = new Mac("XP", "sdh", 1000, motherBoard);
        Storage storage = new HDD("seagate", "5TB", 1000);
        Processor processor = new Intel("intel", "dualcore", 1000);
        DDR3 ramStorage = new DDR3("seagate", "5TB", 1000);

        Computer computer = null;

        if (motherBoard != null && os != null && storage != null && processor != null) {
            computer = new ComputerBuilder(motherBoard, os, storage, ramStorage, processor)
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
                System.out.println("Powering On");
                computer.powerOn();
            } else {
                System.out.println("Shutting down.......");
            }
        }
    }
}
