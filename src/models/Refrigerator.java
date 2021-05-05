package models;

public class Refrigerator extends HouseholdAppliance {
    private int numberOfDoors = 1;

    public Refrigerator() {
    }

    public Refrigerator(String text) {
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

        setNumberOfDoors(Integer.parseInt(fields[8].trim().split(" ")[0]));
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        if (numberOfDoors < 1 || numberOfDoors > 5) System.out.println("incorrect door count");
        else this.numberOfDoors = numberOfDoors;
    }

    @Override
    public String waterproofness() {
        return "Not waterproof";
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
        System.out.printf("Number of doors:   %s%n", (getNumberOfDoors()));
    }

    @Override
    public String getShortFormInfo() {
        return super.getShortFormInfo() + ", " + getNumberOfDoors() + (getNumberOfDoors() == 1 ? " door" : " doors");
    }
}
