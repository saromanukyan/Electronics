package models;


public class Microwave extends HouseholdAppliance {
    private int timerCountdown = 99; //min

    public Microwave() {
    }

    public Microwave(String text) {
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

        setTimerCountdown(Integer.parseInt(fields[8].trim().split(" ")[0]));

    }

    public int getTimerCountdown() {
        return timerCountdown;
    }

    public void setTimerCountdown(int timerCountdown) {
        if (timerCountdown < 10) System.out.println("incorrect value");
        else this.timerCountdown = timerCountdown;
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
        return 2;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.printf("Timer Countdown:   %s%n", (getTimerCountdown() + " min"));
    }

    @Override
    public String getShortFormInfo() {
        return super.getShortFormInfo() + ", " + getTimerCountdown() + " min";
    }
}
