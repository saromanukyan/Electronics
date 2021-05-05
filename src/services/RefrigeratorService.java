package services;

import models.Electronics;
import models.Refrigerator;

import java.util.Arrays;
import java.util.Comparator;

public class RefrigeratorService extends HouseholdApplianceService {
    @Override
    public Electronics create() {
        Refrigerator refrigerator = new Refrigerator();
        refrigerator.setBrand(brand());
        refrigerator.setModel(model());
        refrigerator.setAvailable(isAvailable());
        refrigerator.setReleaseYear(year());
        refrigerator.setPrice(price());
        refrigerator.setColor(color());

        refrigerator.setWeight(weight());
        refrigerator.setLength(length());
        refrigerator.setWidth(width());
        refrigerator.setHeight(height());

        System.out.println("Enter number of doors");
        int doors = s.nextInt();
        refrigerator.setNumberOfDoors(doors);

        return refrigerator;
    }

    @Override
    public Electronics createFromFile(String text) {
        return new Refrigerator(text);
    }

    public static void printNameOFHigher(Electronics[] electronics) {
        Refrigerator[] refrigerators = Arrays.copyOf(electronics, electronics.length, Refrigerator[].class);
        Refrigerator refrigerator = Arrays.stream(refrigerators).max(Comparator.comparingDouble(Refrigerator::getHeight)).get();
        refrigerator.printInfo();
    }
}
