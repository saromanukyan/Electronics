package menus;

import services.MainService;

public class ComputerMenu extends Menu {
    @Override
    public void getMenu() throws ClassNotFoundException {
        String s1 = "1. Create PC";
        String s2 = "2. Create Laptop";

        while (isMenuActive) {
            System.out.println(PURPLE_BRIGHT + "*** Create Computer ***" + RESET_COLOR);
            System.out.println(String.join("\n", s1, s2));
            System.out.println("----------");
            System.out.println("3. Go to Upper menu");
            System.out.println("4. Back to Main Menu");
            System.out.println("5. Exit");

            int command = scanner.nextInt();
            switch (command) {
                case 1 -> {
                    MainService.createProductAndAddToFile("PC");
                    new ConcreteProductMenu("PC").getMenu();
                }
                case 2 -> {
                    MainService.createProductAndAddToFile("Laptop");
                    new ConcreteProductMenu("Laptop").getMenu();
                }
                case 3 -> new ElectronicsMenu().getMenu();
                case 4 -> new MainMenu().getMenu();
                case 5 -> {
                    isMenuActive = false;
                    System.out.println("Thank you!");

                }
                default -> System.out.println(RED_COLOR + "Invalid command number" + RESET_COLOR);
            }

        }
    }
}
