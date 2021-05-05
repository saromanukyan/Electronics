package menus;

import java.util.Scanner;

public abstract class Menu {
    public static final String PURPLE_BRIGHT = "\033[0;95m";
    public static final String RESET_COLOR = "\u001B[0m";
    public static final String RED_COLOR = "\u001B[31m";
    public static Scanner scanner = new Scanner(System.in);
    public static boolean isMenuActive = true;

    abstract void getMenu() throws ClassNotFoundException;

}
