package models;

public class Laptop extends Computer {
    private int batteryLife = 20; // hours

    public Laptop() {
    }

    public Laptop(String text) {
        String[] fields = text.split(",");
        setBrand(fields[0].trim());
        setModel(fields[1].trim());
        setReleaseYear(Integer.parseInt(fields[2].trim()));
        setColor(fields[3].trim());
        setPrice(Double.parseDouble(fields[4].trim().substring(1)));
        setAvailable(!fields[5].contains("Not"));

        setScreenSize(Double.parseDouble(fields[6].trim().split(" ")[0]));
        setRAM(Integer.parseInt(fields[7].trim().split(" ")[0]));
        setHardDrive(fields[8].trim());

        setBatteryLife(Integer.parseInt(fields[9].trim().split(" ")[0]));
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(int batteryLife) {
        if (batteryLife < 0) System.out.println("incorrect value");
        this.batteryLife = batteryLife;
    }

    @Override
    public int warranty() {
        return 2;
    }

    @Override
    public String waterproofness() {
        return "Permeable";
    }

    @Override
    public String impactResistance() {
        return "Low impact";
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.printf("Battery Life:      %s%n", (getRAM() + " hours"));
    }

    @Override
    public String getShortFormInfo() {
        return super.getShortFormInfo() + ", " + getBatteryLife() + " hours";
    }
}
