package models;

public interface Features {
    String waterproofness();

    String impactResistance();

    int warranty();

    default String getFeatures() {
        return waterproofness() + ", " + impactResistance() + ", " + warranty() + " years";
    }

}
