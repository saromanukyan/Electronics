package models;

public interface Dimensions {
    double getLength();

    double getWidth();

    double getHeight();

    default String getDimensions() {
        return String.format("%s x %s x %s cm", getLength(), getWidth(), getHeight());
    }
}
