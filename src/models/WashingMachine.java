package models;

public class WashingMachine extends HouseholdAppliance {
    private int rotationSpeed = 800; // RPM

    public WashingMachine() {
    }

    public WashingMachine(String text) {
        String[] fields = text.split(",");
        setBrand(fields[0].trim());
        setModel(fields[1].trim());
        setReleaseYear(Integer.parseInt(fields[2].trim()));
        setColor(fields[3].trim());
        setPrice(Double.parseDouble(fields[4].trim().substring(1)));
        setAvailable(!fields[5].contains("Not"));

        setWeight(Double.parseDouble(fields[6].trim().split(" ")[0]));
        String[] dimensions = fields[7].split(" ");
        setLength(Double.parseDouble(dimensions[1]));
        setWidth(Double.parseDouble(dimensions[3]));
        setHeight(Double.parseDouble(dimensions[5]));

        setRotationSpeed(Integer.parseInt(fields[8].trim().split(" ")[0]));
    }

    public int getRotationSpeed() {
        return rotationSpeed;
    }

    public void setRotationSpeed(int rotationSpeed) {
        if (rotationSpeed < 1 || rotationSpeed > 25000) System.out.println("incorrect speed");
        else this.rotationSpeed = rotationSpeed;
    }

    @Override
    public String waterproofness() {
        return "Medium Resistant";
    }

    @Override
    public String impactResistance() {
        return "Amortized";
    }

    @Override
    public int warranty() {
        return 3;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.printf("Rotation speed:    %s%n", (getRotationSpeed() + " RPM"));
    }

    @Override
    public String getShortFormInfo() {
        return super.getShortFormInfo() + ", " + getRotationSpeed() + " RPM";
    }
}
