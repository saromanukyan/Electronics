package services;

import models.Electronics;
import models.MobilePhone;

import java.util.Arrays;
import java.util.Comparator;

public abstract class MobilePhoneService extends ElectronicsService {
    protected int numberOfSIMCards() {
        System.out.println("Enter number of SIM cards");
        return s.nextInt();
    }

    protected double screenSize() {
        System.out.println("Enter screen size, (inch)");
        return s.nextDouble();
    }

    public static void printAllSortedByScreenSize(Electronics[] electronics) {
        MobilePhone[] mobilePhones = Arrays.copyOf(electronics, electronics.length, MobilePhone[].class);
        Arrays.sort(mobilePhones, Comparator.comparingDouble(MobilePhone::getScreenSize));
        printAll(mobilePhones);
    }
}
