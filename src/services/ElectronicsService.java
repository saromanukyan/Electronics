package services;

import models.Electronics;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public abstract class ElectronicsService {

    public static Scanner s = new Scanner(System.in);

    protected String brand() {
        System.out.println("Enter brand");
        return s.next();
    }

    protected String model() {
        System.out.println("Enter model");
        return s.next();
    }

    protected int year() {
        System.out.println("Enter release year");
        return s.nextInt();
    }

    protected String color() {
        System.out.println("Enter color");
        return s.next();
    }

    protected double price() {
        System.out.println("Enter price, ($)");
        return s.nextDouble();
    }

    protected boolean isAvailable() {
        System.out.println("Enter is available, (y/n) ");
        return s.next().charAt(0) == 'y';
    }


    public abstract Electronics create();

    public abstract Electronics createFromFile(String text);

    public static void printAll(Electronics[] electronics) {
        for (Electronics e : electronics) {
            e.printInfo();
        }
    }

    public static void printShortFormInfo(Electronics[] electronics) {
        for (Electronics e : electronics) {
            System.out.print("\033[0;95m" + e.getClass().getSimpleName() + ": " + "\u001B[0m");
            System.out.println(e.getShortFormInfo());
        }
    }

    public static void printAllAvailables(Electronics[] electronics) {
        for (Electronics e : electronics) {
            if (e.isAvailable()) e.printInfo();
        }
    }

    public static void printAllAvailablesPriceLess1000(Electronics[] electronics) {
        for (Electronics e : electronics) {
            if (e.isAvailable() && e.getPrice() < 1000) e.printInfo();
        }
    }

    public static void printAllSortedByPrice(Electronics[] electronics) {
        Arrays.sort(electronics, Comparator.comparingDouble(Electronics::getPrice));
        printAll(electronics);
    }

    public static void printOldest(Electronics[] electronics) {
        Electronics e = Arrays.stream(electronics).min(Comparator.comparingInt(Electronics::getReleaseYear)).get();
        e.printInfo();
    }

    public static void printNameOfMostExpensive(Electronics[] electronics) {
        Electronics e = Arrays.stream(electronics).max(Comparator.comparingDouble(Electronics::getPrice)).get();
        System.out.println(e.getFullName());
    }

    public static void printAllWhites(Electronics[] electronics) {
        long count = Arrays.stream(electronics).filter(e -> e.getColor().equals("WHITE")).count();
        System.out.println("Count of Whites = " + count);
    }

}
