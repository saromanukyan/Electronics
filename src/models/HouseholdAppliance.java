package models;

public abstract class HouseholdAppliance extends Electronics implements Dimensions {
    private double length = 25; // cm
    private double width = 25; // cm
    private double height = 25; // cm


    private double weight = 50; // kg

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight < 0 || weight > 200) System.out.println("incorrect weight");
        else this.weight = weight;
    }

    @Override
    public double getLength() {
        return length;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    public void setLength(double length) {
        if (length < 0) System.out.println("incorrect length");
        else this.length = length;
    }

    public void setWidth(double width) {
        if (width < 0) System.out.println("incorrect width");
        else this.width = width;
    }

    public void setHeight(double height) {
        if (height < 0) System.out.println("incorrect heigth");
        else this.height = height;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.printf("Weight:            %s%n", getWeight() + " kg");
        System.out.printf("Dimensions:        %s%n", getDimensions());
    }

    @Override
    public String getShortFormInfo() {
        return super.getShortFormInfo() + ", " + getWeight() + " kg, " + getDimensions();
    }
}
