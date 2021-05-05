package models;

public class TV extends Electronics implements Diagonal {
    private double diagonal = 75;  // inch
    private boolean isSmart;

    public TV() {
    }

    public TV(String text) {
        String[] fields = text.split(",");
        setBrand(fields[0].trim());
        setModel(fields[1].trim());
        setReleaseYear(Integer.parseInt(fields[2].trim()));
        setColor(fields[3].trim());
        setPrice(Double.parseDouble(fields[4].trim().substring(1)));
        setAvailable(!fields[5].contains("Not"));

        setDiagonal(Double.parseDouble(fields[6].trim().split(" ")[0]));
        setSmartTV(!fields[7].contains("Not"));
    }

    public void setDiagonal(double diagonal) {
        if (diagonal < 1) System.out.println("incorrect size");
        else this.diagonal = diagonal;
    }

    public boolean isSmart() {
        return isSmart;
    }

    public void setSmartTV(boolean smart) {
        isSmart = smart;
    }

    @Override
    public double getScreenSize() {
        return diagonal;
    }

    @Override
    public String waterproofness() {
        return "Permeable";
    }

    @Override
    public String impactResistance() {
        return "Not shockproof";
    }

    @Override
    public int warranty() {
        return 3;
    }

    @Override
    public String getShortFormInfo() {
        return super.getShortFormInfo() + ", " + getScreenSize() + " inch, " + (isSmart() ? "SmartTV" : "Not SmartTV");
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.printf("Is SmartTV:        %s%n", isSmart() ? "YES" : "NO");
        System.out.printf("Diagonal:          %s%n", getScreenSize() + " inch");
    }
}
