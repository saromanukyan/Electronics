package menus;

import services.MainService;

public class ElectronicsMenu extends Menu {
    @Override
    public void getMenu() throws ClassNotFoundException {
        String s1 = "1. Create MobilePhone";
        String s2 = "2. Create Computer";
        String s3 = "3. Create TV";
        String s4 = "4. Create HouseholdAppliance";
        while (isMenuActive) {
            System.out.println(PURPLE_BRIGHT + "*** Create Electronics ***" + RESET_COLOR);
            System.out.println(String.join("\n", s1, s2, s3, s4));
            System.out.println("----------");
            System.out.println("5. Back to Main Menu");
            System.out.println("6. Exit");

            int command = scanner.nextInt();
            switch (command) {
                case 1 -> new MobilePhoneMenu().getMenu();
                case 2 -> new ComputerMenu().getMenu();
                case 3 -> {
                    MainService.createProductAndAddToFile("TV");
                    new ConcreteProductMenu("TV").getMenu();
                }
                case 4 -> new HouseholdApplianceMenu().getMenu();
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
