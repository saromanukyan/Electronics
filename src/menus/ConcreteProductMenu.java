package menus;

import services.MainService;

public class ConcreteProductMenu extends Menu {
    private final String productName;

    public ConcreteProductMenu(String productName) {
        this.productName = productName;
    }

    @Override
    public void getMenu() throws ClassNotFoundException {
        while (isMenuActive) {
            System.out.println(PURPLE_BRIGHT + "*** What's next? ***" + RESET_COLOR);
            System.out.println("1. Create another " + productName);
            System.out.println("----------");
            System.out.println("2. Back to Main Menu");
            System.out.println("3. Exit");

            int command = scanner.nextInt();
            switch (command) {
                case 1 -> {
                    MainService.createProductAndAddToFile(productName);
                    new ConcreteProductMenu(productName).getMenu();
                }
                case 3 -> new MainMenu().getMenu();
                case 4 -> {
                    isMenuActive = false;
                    System.out.println("Thank you!");
                }
                default -> System.out.println(RED_COLOR + "Invalid command number" + RESET_COLOR);
            }

        }
    }
}
