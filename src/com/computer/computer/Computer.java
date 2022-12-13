package com.computer.computer;

import com.computer.hardware.part.keyboard.Keyboard;
import com.computer.hardware.part.monitor.Monitor;
import com.computer.hardware.part.motherboard.MotherBoard;
import com.computer.hardware.part.networkcard.NetworkCard;
import com.computer.software.os.Os;
import com.computer.hardware.part.storage.RAM.DDR3;
import com.computer.hardware.part.storage.Storage;

public class Computer {
    private final Monitor monitor;
    private final Keyboard keyboards;
    private final MotherBoard motherBoard;
    private final NetworkCard networkCard;
    private final Os os;
    private final DDR3 ram;
    private final Storage storage;

    public Computer(Monitor monitor, Keyboard keyboards, MotherBoard motherBoard, NetworkCard networkCard, Os os,
                    Storage storage, DDR3 ram) {
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
                " keyboards=" + keyboards.getId() +
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
