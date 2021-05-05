package main;

import menus.MainMenu;

public class Test {
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        try {
            mainMenu.getMenu();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
