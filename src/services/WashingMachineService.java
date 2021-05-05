package services;

import models.Electronics;
import models.WashingMachine;

import java.util.Arrays;
import java.util.Comparator;

public class WashingMachineService extends HouseholdApplianceService {
    @Override
    public Electronics create() {
        WashingMachine washingMachine = new WashingMachine();
        washingMachine.setBrand(brand());
        washingMachine.setModel(model());
        washingMachine.setAvailable(isAvailable());
        washingMachine.setReleaseYear(year());
        washingMachine.setPrice(price());
        washingMachine.setColor(color());

        washingMachine.setWeight(weight());
        washingMachine.setLength(length());
        washingMachine.setWidth(width());
        washingMachine.setHeight(height());

        System.out.println("Enter rotation speed (RPM)");
        int speed = s.nextInt();
        washingMachine.setRotationSpeed(speed);

        return washingMachine;
    }

    @Override
    public Electronics createFromFile(String text) {
        return new
                WashingMachine(text);
    }

    public static void printinDescendingRPMOrder(Electronics[] e) {
        WashingMachine[] washingMachines = Arrays.copyOf(e, e.length, WashingMachine[].class);
        Arrays.sort(washingMachines, Comparator.comparingDouble(WashingMachine::getRotationSpeed).reversed());
        printAll(washingMachines);
    }
}
