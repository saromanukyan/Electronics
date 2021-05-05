package services;

import models.Electronics;
import models.SmartPhone;


public class SmartPhoneService extends MobilePhoneService {
    @Override
    public Electronics create() {
        SmartPhone smartPhone = new SmartPhone();

        smartPhone.setBrand(brand());
        smartPhone.setModel(model());
        smartPhone.setAvailable(isAvailable());
        smartPhone.setReleaseYear(year());
        smartPhone.setPrice(price());
        smartPhone.setColor(color());

        smartPhone.setNumberOfSIMCards(numberOfSIMCards());
        smartPhone.setScreenSize(screenSize());

        System.out.println("Enter camera resolution, (MP)");
        float cameraResolution = s.nextFloat();
        smartPhone.setCameraResolution(cameraResolution);

        System.out.println("Enter RAM Gigabytes, (GB)");
        int ram = s.nextInt();
        smartPhone.setRAM(ram);

        return smartPhone;
    }


    @Override
    public Electronics createFromFile(String text) {
        return new SmartPhone(text);
    }

}
