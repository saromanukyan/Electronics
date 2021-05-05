package models;

public class RegularPhone extends MobilePhone {
    private String shellType = "monoblock";

    public RegularPhone() {
    }

    public RegularPhone(String text) {
        String[] fields = text.split(",");
        setBrand(fields[0].trim());
        setModel(fields[1].trim());
        setReleaseYear(Integer.parseInt(fields[2].trim()));
        setColor(fields[3].trim());
        setPrice(Double.parseDouble(fields[4].trim().substring(1)));
        setAvailable(!fields[5].contains("Not"));

        setNumberOfSIMCards(Character.getNumericValue(fields[6].trim().charAt(0)));
        setScreenSize(Double.parseDouble(fields[7].trim().split(" ")[0]));
        setShellType(fields[8].trim());
    }

    public String getShellType() {
        return shellType;
    }

    public void setShellType(String shellType) {
        if (shellType.length() == 0) {
            System.out.println("incorrect type");
            return;
        }
        if (shellType.contains(",")) this.shellType = shellType.replaceAll(",", "");
        else this.shellType = shellType;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.printf("Shell Type:        %s%n", getShellType());

    }

    @Override
    public String getShortFormInfo() {
        return super.getShortFormInfo() + ", " + getShellType();
    }


    @Override
    public int warranty() {
        return 3;
    }

    @Override
    public String waterproofness() {
        return "Medium resistant";
    }

    @Override
    public String impactResistance() {
        return "Shockproof";
    }

}
