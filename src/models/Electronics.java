package models;

public abstract class Electronics implements Features {
    private String brand = "Samsung";
    private String model = "A 12";
    private int releaseYear = 2000;
    private double price = 999;
    private String color = "White";
    private boolean isAvailable;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (brand.contains(",")) brand = brand.replaceAll(",", "");
        if (brand.length() == 0) {
            System.out.println("incorrect brand");
            return;
        }

        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {

        if (model.contains(",")) {
            model = model.replaceAll(",", "");
        }
        if (model.length() == 0) {
            System.out.println("incorrect model");
            return;
        }
        this.model = model;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        if (releaseYear < 1990 || releaseYear > 2021) System.out.println("incorrect year");
        else this.releaseYear = releaseYear;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) System.out.println("incorrect price");
        else this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color.contains(",")) {
            color = color.replaceAll(",", "");
        }
        if (color.length() == 0) {
            System.out.println("incorrect model");
            return;
        }
        this.color = color.toUpperCase();
    }


    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getFullName() {
        return getBrand() + " " + getModel();
    }

    public void printInfo() {
        System.out.println("\033[0;95m" + this.getClass().getSimpleName() + ": " + getFullName() + "\u001B[0m");

        System.out.printf("Release Year:      %s%n", getReleaseYear());
        System.out.printf("Color:             %s%n", getColor());
        System.out.printf("Price:             %s%n", "$" + getPrice());
        System.out.printf("Is Available:      %s%n", isAvailable() ? "YES" : "NO");
        String[] features = getFeatures().split(",");
        System.out.printf("Waterproofness:    %s%n", features[0].trim());
        System.out.printf("ImpactResistance:  %s%n", features[1].trim());
        System.out.printf("Warranty:          %s%n", features[2].trim());
    }

    public String getShortFormInfo() {
        return String.format("%s, %s, %d, %s, $%s, %s", getBrand(), getModel(),
                getReleaseYear(), getColor(), getPrice(),
                isAvailable() ? "Available" : "Not Available");
        //return getBrand()+", "+getModel()+", "+ getReleaseYear()+", "+getColor()+", $"+getPrice()+", "+(isAvailable()?"Available":"Not Available");
    }

}
