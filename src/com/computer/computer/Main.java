package com.computer.computer;

import com.computer.part.keyboard.Keyboard;
import com.computer.part.keyboard.Qwerty;
import com.computer.part.monitor.Led;
import com.computer.part.monitor.Monitor;
import com.computer.part.motherboard.MicroAtxMotherBoard;
import com.computer.part.motherboard.MotherBoard;
import com.computer.part.networkcard.NetworkCard;
import com.computer.part.networkcard.Wired;
import com.computer.part.os.Mac;
import com.computer.part.os.Os;
import com.computer.part.processor.Intel;
import com.computer.part.processor.Processor;
import com.computer.part.storage.HDD;
import com.computer.part.storage.RAM;
import com.computer.part.storage.Storage;

import java.util.Scanner;

public class Main {
    public static int getInteger() {
        Scanner sc = new Scanner(System.in);
        try {
            return sc.nextInt();
        } catch (Exception e) {
            System.out.println("Enter correct option!!!.");
            return getInteger();
        }
    }

    public static void main(String[] args) {

        MotherBoard motherBoard = new MicroAtxMotherBoard("ASUS", "intel socket", 1000);
        Monitor monitor = new Led("Dell", "17 inch monitor", 1000);
        Keyboard keyboard = new Qwerty("mac", "Mechanical keyboard", 1000);
        NetworkCard nic = new Wired("mac", "parallel", 1000);
        Os os = new Mac("XP", "sdh", 1000, motherBoard);
        Storage storage = new HDD("seagate", "5TB", 1000);
        Processor processor = new Intel("intel", "dualcore", 1000);
        RAM ramStorage = new RAM("seagate", "5TB", 1000, processor);

        Computer computer = null;

        if (motherBoard != null && os != null && storage != null) {
            computer = new ComputerBuilder(motherBoard, os, storage, ramStorage, processor)
                    .setMonitor(monitor)
                    .setKeyboard(keyboard)
                    .setNetworkCard(nic)
                    .build();
        }
        if (computer == null) {
            System.out.println("no computer!!!");
        } else {
            System.out.println("1.Power On\n2.Power Off");
            if (getInteger() == 1) {
                System.out.println("Powering On");
                computer.powerOn();
            } else {
                System.out.println("Shutting down.......");
            }
        }
    }
}
