package menus;

public class MainMenu extends Menu {
    @Override
    public void getMenu() throws ClassNotFoundException {
        String s1 = "1. Create Electronics";
        String s2 = "2. Go to Electronics Service";
        String s3 = "3. Exit";

        while (isMenuActive) {

            System.out.println(PURPLE_BRIGHT + "*** Main Menu ***" + RESET_COLOR);
            System.out.println(String.join("\n", s1, s2, s3));
            int command = scanner.nextInt();
            switch (command) {
                case 1 -> new ElectronicsMenu().getMenu();
                case 2 -> new ServiceMenu("Electronics").getMenu();
                case 3 -> {
                    isMenuActive = false;
                    System.out.println("Thank you!");

                }
                default -> System.out.println(RED_COLOR + "Invalid command number" + RESET_COLOR);
            }
        }
    }
}
