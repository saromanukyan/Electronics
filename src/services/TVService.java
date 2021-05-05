package services;

import models.Electronics;
import models.TV;

import java.util.Arrays;

public class TVService extends ElectronicsService {
    @Override
    public Electronics create() {
        TV tv = new TV();
        tv.setBrand(brand());
        tv.setModel(model());
        tv.setAvailable(isAvailable());
        tv.setReleaseYear(year());
        tv.setPrice(price());
        tv.setColor(color());

        System.out.println("Enter is smartTV, (y/n) ");
        boolean isSmart = s.next().charAt(0) == 'y';
        tv.setSmartTV(isSmart);

        System.out.println("Enter diagonal, (inch)");
        double diagonal = s.nextDouble();

        tv.setDiagonal(diagonal);
        return tv;
    }

    @Override
    public Electronics createFromFile(String text) {
        return new TV(text);
    }

    public static void printAllSmartTVNames(Electronics[] electronics) {
        TV[] tvs = Arrays.copyOf(electronics, electronics.length, TV[].class);
        for (TV tv : tvs) {
            if (tv.isSmart())
                System.out.println(tv.getFullName());
        }
    }

}
