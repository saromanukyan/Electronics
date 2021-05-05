package models;

public class SmartPhone extends MobilePhone implements Hardware {
    private float cameraResolution = 5.0f; // MP
    private int RAM = 16; // GB

    public SmartPhone() {
    }

    public SmartPhone(String text) {
        String[] fields = text.split(",");
        setBrand(fields[0].trim());
        setModel(fields[1].trim());
        setReleaseYear(Integer.parseInt(fields[2].trim()));
        setColor(fields[3].trim());
        setPrice(Double.parseDouble(fields[4].trim().substring(1)));
        setAvailable(!fields[5].contains("Not"));
        setNumberOfSIMCards(Character.getNumericValue(fields[6].trim().charAt(0)));
        setScreenSize(Double.parseDouble(fields[7].trim().split(" ")[0]));
        setCameraResolution(Float.parseFloat(fields[8].trim().split(" ")[0]));
        setRAM(Integer.parseInt(fields[9].trim().split(" ")[0]));
    }

    public void setRAM(int RAM) {
        if (RAM < 1 || RAM > 1000) System.out.println("incorrect number");
        else this.RAM = RAM;
    }

    @Override
    public int getRAM() {
        return RAM;
    }

    public float getCameraResolution() {
        return cameraResolution;
    }

    public void setCameraResolution(float cameraResolution) {
        if (cameraResolution < 0) System.out.println("incorrect number");
        else this.cameraResolution = cameraResolution;
    }


    @Override
    public int warranty() {
        return 2;
    }

    @Override
    public String waterproofness() {
        return "Water resistant";
    }

    @Override
    public String impactResistance() {
        return "Low impact";
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.printf("Camera:            %s%n", (getCameraResolution() + " MP"));
        System.out.printf("RAM:               %s%n", (getRAM() + " GB"));
    }

    @Override
    public String getShortFormInfo() {
        return super.getShortFormInfo() + ", " + getCameraResolution() + " MP, " + getRAM() + " GB";
    }
}
