package com.computer.computer;

import com.computer.part.keyboard.Keyboard;
import com.computer.part.monitor.Monitor;
import com.computer.part.motherboard.MotherBoard;
import com.computer.part.networkcard.NetworkCard;
import com.computer.part.os.Os;
import com.computer.part.storage.RAM;
import com.computer.part.storage.Storage;

public class Computer {
    private Monitor monitor;
    private Keyboard keyboards;
    private MotherBoard motherBoard;
    private NetworkCard networkCard;
    private Os os;
    private RAM ram;
    private Storage storage;

    public Computer(Monitor monitor, Keyboard keyboards, MotherBoard motherBoard, NetworkCard networkCard, Os os,
                    Storage storage, RAM ram) {
        this.monitor = monitor;
        this.keyboards = keyboards;
        this.motherBoard = motherBoard;
        this.networkCard = networkCard;
        this.os = os;
        this.storage = storage;
        this.ram = ram;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "monitor=" + monitor.getId() +
                ", keyboards=" + keyboards.getId() +
                ", motherBoard=" + motherBoard.getId() +
                ", networkCard=" + networkCard.getId() +
                ", os=" + os.getId() +
                ", ram=" + ram.getId() +
                ", storage=" + storage.getId() +
                '}';
    }

    public void powerOn() {
        motherBoard.biosBoot();
        os.driverFunction();
    }
}
