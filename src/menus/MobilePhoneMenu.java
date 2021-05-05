package menus;

import services.MainService;

public class MobilePhoneMenu extends Menu {
    @Override
    public void getMenu() throws ClassNotFoundException {
        String s1 = "1. Create RegularPhone";
        String s2 = "2. Create SmartPhone";

        while (isMenuActive) {
            System.out.println(PURPLE_BRIGHT + "*** Create MobilePhone ***" + RESET_COLOR);
            System.out.println(String.join("\n", s1, s2));
            System.out.println("----------");
            System.out.println("3. Go to Upper Menu");
            System.out.println("4. Back to Main Menu");
            System.out.println("5. Exit");

            int command = scanner.nextInt();
            switch (command) {
                case 1 -> {
                    MainService.createProductAndAddToFile("RegularPhone");
                    new ConcreteProductMenu("RegularPhone").getMenu();
                }
                case 2 -> {
                    MainService.createProductAndAddToFile("SmartPhone");
                    new ConcreteProductMenu("SmartPhone").getMenu();
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
