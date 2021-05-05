package menus;

import services.MainService;

public class HouseholdApplianceMenu extends Menu {
    @Override
    public void getMenu() throws ClassNotFoundException {
        String s1 = "1. Create Microwave";
        String s2 = "2. Create Refrigerator";
        String s3 = "3. Create Washing Machine";

        while (isMenuActive) {
            System.out.println(PURPLE_BRIGHT + "*** Create Household Appliances ***" + RESET_COLOR);
            System.out.println(String.join("\n", s1, s2, s3));
            System.out.println("----------");
            System.out.println("4. Go to Upper Menu");
            System.out.println("5. Back to Main Menu");
            System.out.println("6. Exit");

            int command = scanner.nextInt();
            switch (command) {
                case 1 -> {
                    MainService.createProductAndAddToFile("Microwave");
                    new ConcreteProductMenu("Microwave").getMenu();
                }
                case 2 -> {
                    MainService.createProductAndAddToFile("Refrigerator");
                    new ConcreteProductMenu("Refrigerator").getMenu();
                }
                case 3 -> {
                    MainService.createProductAndAddToFile("WashingMachine");
                    new ConcreteProductMenu("WashingMachine").getMenu();
                }
                case 4 -> new ElectronicsMenu().getMenu();

                case 5 -> new MainMenu().getMenu();
                case 6 -> {
                    isMenuActive = false;
                    System.out.println("Thank you!");

                }
                default -> System.out.println(RED_COLOR + "Invalid command number" + RESET_COLOR);
            }

        }
    }
}
