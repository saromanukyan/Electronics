package services;

import models.Computer;
import models.Electronics;

import java.util.Arrays;

public abstract class ComputerService extends ElectronicsService {
    protected double screenSize() {
        System.out.println("Enter screen size, (inch)");
        return s.nextDouble();
    }

    protected int RAM() {
        System.out.println("Enter RAM, (GB)");
        return s.nextInt();
    }

    protected String hardDrive() {
        System.out.println("Enter hardDrive type");
        System.out.println("1. HDD");
        System.out.println("2. SSD");
        int number = s.nextInt();
        return number == 1 ? "HDD" : "SSD";
    }

    public static void printSSDsRAMlessOrEqual16GB(Electronics[] electronics) {
        Computer[] computers = Arrays.copyOf(electronics, electronics.length, Computer[].class);
        for (Computer computer : computers) {
            if (computer.getHardDrive().equals("SSD") && computer.getRAM() <= 16)
                computer.printInfo();
        }
    }
}
