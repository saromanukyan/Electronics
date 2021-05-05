package services;

import models.Electronics;
import models.Laptop;
import models.TV;

import java.util.Arrays;
import java.util.Comparator;

public class LaptopService extends ComputerService {
    @Override
    public Electronics create() {
        Laptop laptop = new Laptop();

        laptop.setBrand(brand());
        laptop.setModel(model());
        laptop.setAvailable(isAvailable());
        laptop.setReleaseYear(year());
        laptop.setPrice(price());
        laptop.setColor(color());

        laptop.setScreenSize(screenSize());
        laptop.setRAM(RAM());
        laptop.setHardDrive(hardDrive());

        System.out.println("Enter battery life, (hours)");
        int batteryLife = s.nextInt();
        laptop.setBatteryLife(batteryLife);

        return laptop;
    }

    @Override
    public Electronics createFromFile(String text) {
        return new Laptop(text);
    }

    public static void printButteryLifeMore20hours(Electronics[] electronics) {
        Laptop[] laptops = Arrays.copyOf(electronics, electronics.length, Laptop[].class);
        Laptop laptop = Arrays.stream(laptops).max(Comparator.comparingDouble(Laptop::getBatteryLife)).get();
        laptop.printInfo();
    }
}
