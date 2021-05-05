package services;

import models.Electronics;
import models.RegularPhone;

import java.util.Arrays;

public class RegularPhoneService extends MobilePhoneService {

    private String shelType(int number) {
        return switch (number) {
            case 1 -> "monoblock";
            case 2 -> "clamshell";
            default -> "slider";
        };
    }

    @Override
    public Electronics create() {

        RegularPhone phone = new RegularPhone();
        phone.setBrand(brand());
        phone.setModel(model());
        phone.setAvailable(isAvailable());
        phone.setReleaseYear(year());
        phone.setPrice(price());
        phone.setColor(color());

        phone.setNumberOfSIMCards(numberOfSIMCards());
        phone.setScreenSize(screenSize());

        System.out.println("Enter shell type");
        System.out.println("1. monoblock");
        System.out.println("2. clamshell");
        System.out.println("3. slider");
        int type = s.nextInt();
        phone.setShellType(shelType(type));

        return phone;
    }

    @Override
    public Electronics createFromFile(String text) {
        return new RegularPhone(text);
    }

    public static void printAllMonoblocks(Electronics[] electronics) {
        RegularPhone[] phones = Arrays.copyOf(electronics, electronics.length, RegularPhone[].class);
        for (RegularPhone phone : phones) {
            if (phone.getShellType().equals("monoblock")) phone.printInfo();
        }
    }
}
