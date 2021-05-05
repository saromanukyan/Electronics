package models;

public class PC extends Computer {
    private boolean isAssembled;

    public PC() {
    }

    public PC(String text) {
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

        setAssembled(!fields[9].contains("Not"));
    }

    public boolean isAssembled() {
        return isAssembled;
    }

    public void setAssembled(boolean assembled) {
        isAssembled = assembled;
    }

    @Override
    public String waterproofness() {
        return "Not waterproof";
    }

    @Override
    public String impactResistance() {
        return "Not shockproof";
    }

    @Override
    public int warranty() {
        return 1;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.printf("Is Assembled:      %s%n", isAvailable() ? "YES" : "NO");
    }

    @Override
    public String getShortFormInfo() {
        return super.getShortFormInfo() + ", " + (isAssembled() ? "Assembled" : "Not Assembled");
    }
}
