package services;

import models.Computer;
import models.Electronics;
import models.HouseholdAppliance;

import java.util.Arrays;
import java.util.Comparator;

public abstract class HouseholdApplianceService extends ElectronicsService {
    protected double weight() {
        System.out.println("Enter weight, (kg)");
        return s.nextDouble();
    }

    protected double length() {
        System.out.println("Enter length, (cm)");
        return s.nextDouble();
    }

    protected double width() {
        System.out.println("Enter width, (cm)");
        return s.nextDouble();
    }

    protected double height() {
        System.out.println("Enter height, (cm)");
        return s.nextDouble();
    }

    public static void printNameOfHeavier(Electronics[] electronics) {
        HouseholdAppliance[] householdAppliances = Arrays.copyOf(electronics, electronics.length, HouseholdAppliance[].class);
        HouseholdAppliance h = Arrays.stream(householdAppliances).max(Comparator.comparingDouble(HouseholdAppliance::getWeight)).get();
        h.printInfo();
    }
}
