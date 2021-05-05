package services;

import models.Electronics;
import models.PC;

public class PCService extends ComputerService {
    @Override
    public Electronics create() {
        PC pc = new PC();

        pc.setBrand(brand());
        pc.setModel(model());
        pc.setAvailable(isAvailable());
        pc.setReleaseYear(year());
        pc.setPrice(price());
        pc.setColor(color());

        pc.setScreenSize(screenSize());
        pc.setRAM(RAM());
        pc.setHardDrive(hardDrive());

        System.out.println("Enter is assembled, (y/n) ");
        boolean isAssembled = s.next().charAt(0) == 'y';
        pc.setAssembled(isAssembled);
        return pc;
    }

    @Override
    public Electronics createFromFile(String text) {
        return new PC(text);
    }
}
