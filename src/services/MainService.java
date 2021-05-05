package services;

import models.*;

import java.io.IOException;

public class MainService {

    private static final Electronics[] electronics = {new SmartPhone(), new RegularPhone(),
            new TV(), new Laptop(), new PC(),
            new Microwave(), new WashingMachine(), new Refrigerator()};
    private static final ElectronicsService[] services = {new SmartPhoneService(), new RegularPhoneService(),
            new TVService(), new LaptopService(), new PCService(),
            new MicrowaveService(), new WashingMachineService(), new RefrigeratorService()};

    public static Electronics[] getElectronicsArray(String productType) throws ClassNotFoundException, IOException {
        Class<?> clazzService = Class.forName("services." + productType + "Service");
        Class<?> clazzProduct = Class.forName("models." + productType);
        String[] read;
        int length = 0;
        for (Electronics e : electronics) {
            if (clazzProduct.isInstance(e)) {
                String fileName = e.getClass().getSimpleName();
                read = FileService.read("data\\" + fileName + ".txt");
                length += read.length;
            }
        }
        Electronics[] products = new Electronics[length];
        int index = 0;
        for (ElectronicsService es : services) {
            if (clazzService.isInstance(es)) {
                String fileName = es.getClass().getSimpleName().replace("Service", "");
                read = FileService.read("data\\" + fileName + ".txt");
                for (String s : read) {
                    products[index++] = es.createFromFile(s);
                }
            }
        }
        return products;
    }

    public static void createProductAndAddToFile(String productName) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("services." + productName + "Service");
        for (ElectronicsService es : services) {
            if (clazz.isInstance(es)) {
                Electronics e = es.create();
                FileService.addObjectsToFile("data\\" + productName + ".txt", ("\n" + e.getShortFormInfo()));
                break;
            }
        }
    }


}
