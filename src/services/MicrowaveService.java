package services;

import models.Electronics;
import models.Microwave;

public class MicrowaveService extends HouseholdApplianceService {
    @Override
    public Electronics create() {
        Microwave microwave = new Microwave();
        microwave.setBrand(brand());
        microwave.setModel(model());
        microwave.setAvailable(isAvailable());
        microwave.setReleaseYear(year());
        microwave.setPrice(price());
        microwave.setColor(color());

        microwave.setWeight(weight());
        microwave.setLength(length());
        microwave.setWidth(width());
        microwave.setHeight(height());

        System.out.println("Enter timer max countdown, (minutes)");
        int timerCountdown = s.nextInt();
        microwave.setTimerCountdown(timerCountdown);

        return microwave;
    }

    @Override
    public Electronics createFromFile(String text) {
        return new Microwave(text);
    }
}
