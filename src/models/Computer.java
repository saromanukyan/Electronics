package models;

public abstract class Computer extends Electronics implements Diagonal, Hardware {
    private String hardDrive = "SSD";
    private double screenSize = 1;  // inch
    private int RAM = 16; // GB

    public String getHardDrive() {
        return hardDrive;
    }

    public void setHardDrive(String hardDrive) {
        this.hardDrive = hardDrive;
    }

    public void setScreenSize(double screenSize) {
        if (screenSize < 1) System.out.println("incorrect size");
        else this.screenSize = screenSize;
    }

    @Override
    public double getScreenSize() {
        return screenSize;
    }

    public void setRAM(int RAM) {
        if (RAM < 1 || RAM > 1000) System.out.println("incorrect number");
        else this.RAM = RAM;
    }

    @Override
    public int getRAM() {
        return RAM;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.printf("Screen:            %s%n", getScreenSize() + " inch");
        System.out.printf("RAM:               %s%n", getRAM() + " GB");
        System.out.printf("HardDrive:         %s%n", getHardDrive());
    }

    @Override
    public String getShortFormInfo() {
        return super.getShortFormInfo() + ", " + getScreenSize() + " inch, " + getRAM() + " GB, " + getHardDrive();
    }
}
