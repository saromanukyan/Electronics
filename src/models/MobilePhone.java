package models;


public abstract class MobilePhone extends Electronics implements Diagonal {
    private int numberOfSIMCards = 1;
    private double screenSize = 1;  // inch

    public void setScreenSize(double screenSize) {
        if (screenSize < 1) System.out.println("incorrect size");
        else this.screenSize = screenSize;
    }

    @Override
    public double getScreenSize() {
        return screenSize;
    }

    public int getNumberOfSIMCards() {
        return numberOfSIMCards;
    }

    public void setNumberOfSIMCards(int numberOfSIMCards) {
        if (numberOfSIMCards < 1 || numberOfSIMCards > 9) System.out.println("incorrect number");
        else this.numberOfSIMCards = numberOfSIMCards;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.printf("SIM cards:         %s%n", getNumberOfSIMCards());
        System.out.printf("Screen:            %s%n", getScreenSize() + " inch");

    }

    @Override
    public String getShortFormInfo() {
        return super.getShortFormInfo() + ", " + getNumberOfSIMCards() +
                (getNumberOfSIMCards() == 1 ? " Sim Card, " : " Sim Cards, ") + getScreenSize() + " inch";
    }
}
