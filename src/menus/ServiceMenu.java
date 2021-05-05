package menus;

import models.Electronics;
import services.*;

import java.io.IOException;

public class ServiceMenu extends Menu {
    private final String productType; // MobilePhone, Electronics
    static int key = 0;
    Electronics[] electronics;

    ServiceMenu(String productType) {
        this.productType = productType;
        try {
            this.electronics = MainService.getElectronicsArray(productType);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getMenu() throws ClassNotFoundException {
        while (isMenuActive) {

            System.out.println(PURPLE_BRIGHT + "*** " + productType + " Service ***" + RESET_COLOR);
            switch (productType) {
                case "Electronics" -> {
                    electronicsText();
                    electronicsSwitcher(scanner.nextInt());
                }
                case "MobilePhone" -> {
                    mobilePhoneText();
                    mobilePhoneSwitcher(scanner.nextInt());
                }
                case "RegularPhone" -> {
                    regularPhoneText();
                    regularPhoneSwitcher(scanner.nextInt());
                }
                case "SmartPhone" -> {
                    smartPhoneText();
                    smartPhoneSwitcher(scanner.nextInt());
                }
                case "TV" -> {
                    tvText();
                    tvSwitcher(scanner.nextInt());
                }
                case "Computer" -> {
                    computerText();
                    computerSwitcher(scanner.nextInt());
                }
                case "PC" -> {
                    PCText();
                    PCSwitcher(scanner.nextInt());
                }
                case "Laptop" -> {
                    laptopText();
                    laptopSwitcher(scanner.nextInt());
                }
                case "HouseholdAppliance" -> {
                    householdApplianceText();
                    householdApplianceSwitcher(scanner.nextInt());
                }
                case "Microwave" -> {
                    microwaveText();
                    microwaveSwitcher(scanner.nextInt());
                }
                case "WashingMachine" -> {
                    washingMachineText();
                    washingMachineSwitcher(scanner.nextInt());
                }
                case "Refrigerator" -> {
                    refrigeratorText();
                    refrigeratorSwitcher(scanner.nextInt());
                }
                default -> throw new IllegalStateException("Unexpected value: " + productType);
            }

        }

    }

    private void electronicsTextFirst8Lines() {
        System.out.println((++key) + ". Print all " + productType + "s");// 1
        System.out.println((++key) + ". Print all " + productType + "s in short form");// 2
        System.out.println((++key) + ". Print all available " + productType + "s");// 3
        System.out.println((++key) + ". Print all available " + productType + "s price less $1000");// 4
        System.out.println((++key) + ". Print all " + productType + "s sorted by price");// 5
        System.out.println((++key) + ". Print oldest " + productType);// 6
        System.out.println((++key) + ". Print name of most expensive " + productType);// 7
        System.out.println((++key) + ". Print count of WHITE " + productType + "s");// 8
    }

    private void electronicsText() {
        System.out.println((++key) + ". Print all " + productType);// 1
        System.out.println((++key) + ". Print all " + productType + " in short form");// 2
        System.out.println((++key) + ". Print all available " + productType);// 3
        System.out.println((++key) + ". Print all available " + productType + " price less $1000");// 4
        System.out.println((++key) + ". Print all " + productType + " sorted by price");// 5
        System.out.println((++key) + ". Print oldest " + productType);// 6
        System.out.println((++key) + ". Print name of most expensive " + productType);// 7
        System.out.println((++key) + ". Print count of WHITE " + productType);// 8
        System.out.println("----------");
        System.out.println((++key) + ". Go to MobilePhone Service");// 9
        System.out.println((++key) + ". Go to Computer Service");// 10
        System.out.println((++key) + ". Go to HouseholdAppliance Service");// 11
        System.out.println((++key) + ". Go to TV Service"); //12
        System.out.println("----------");
        System.out.println((++key) + ". Back to Main Menu");//13
        System.out.println((++key) + ". Exit");//14
        key = 0;
    }

    private void electronicsSwitcher(int command) throws ClassNotFoundException {
        switch (command) {
            case 1 -> ElectronicsService.printAll(electronics);
            case 2 -> ElectronicsService.printShortFormInfo(electronics);
            case 3 -> ElectronicsService.printAllAvailables(electronics);
            case 4 -> ElectronicsService.printAllAvailablesPriceLess1000(electronics);
            case 5 -> ElectronicsService.printAllSortedByPrice(electronics);
            case 6 -> ElectronicsService.printOldest(electronics);
            case 7 -> ElectronicsService.printNameOfMostExpensive(electronics);
            case 8 -> ElectronicsService.printAllWhites(electronics);

            case 9 -> new ServiceMenu("MobilePhone").getMenu();
            case 10 -> new ServiceMenu("Computer").getMenu();
            case 11 -> new ServiceMenu("HouseholdAppliance").getMenu();
            case 12 -> new ServiceMenu("TV").getMenu();

            case 13 -> new MainMenu().getMenu();
            case 14 -> {
                isMenuActive = false;
                System.out.println("Thank you!");
            }
            default -> System.out.println(RED_COLOR + "Invalid command number" + RESET_COLOR);
        }
    }

    private void mobilePhoneText() {
        electronicsTextFirst8Lines();

        System.out.println((++key) + ". Print all " + productType + "s sorted by screen size");// 9
        System.out.println("----------");
        System.out.println((++key) + ". Go to RegularPhone Service");//10
        System.out.println((++key) + ". Go to SmartPhone Service");//11
        System.out.println("----------");
        System.out.println((++key) + ". Go to Upper Menu");
        System.out.println((++key) + ". Back to Main Menu");//
        System.out.println((++key) + ". Exit");//

        key = 0;
    }

    private void mobilePhoneSwitcher(int command) throws ClassNotFoundException {
        switch (command) {
            case 1 -> MobilePhoneService.printAll(electronics);
            case 2 -> MobilePhoneService.printShortFormInfo(electronics);
            case 3 -> MobilePhoneService.printAllAvailables(electronics);
            case 4 -> MobilePhoneService.printAllAvailablesPriceLess1000(electronics);
            case 5 -> MobilePhoneService.printAllSortedByPrice(electronics);
            case 6 -> MobilePhoneService.printOldest(electronics);
            case 7 -> MobilePhoneService.printNameOfMostExpensive(electronics);
            case 8 -> MobilePhoneService.printAllWhites(electronics);
            case 9 -> MobilePhoneService.printAllSortedByScreenSize(electronics);

            case 10 -> new ServiceMenu("RegularPhone").getMenu();
            case 11 -> new ServiceMenu("SmartPhone").getMenu();

            case 12 -> new ServiceMenu("Electronics").getMenu();
            case 13 -> new MainMenu().getMenu();
            case 14 -> {
                isMenuActive = false;
                System.out.println("Thank you!");
            }
            default -> System.out.println(RED_COLOR + "Invalid command number" + RESET_COLOR);
        }
    }

    private void regularPhoneText() {
        electronicsTextFirst8Lines();

        System.out.println((++key) + ". Print all " + productType + "s sorted by screen size");// 9

        System.out.println((++key) + ". Print all monoblock shell " + productType + "s");// 10
        System.out.println("----------");
        System.out.println((++key) + ". Go to Upper Menu");
        System.out.println((++key) + ". Back to Main Menu");//
        System.out.println((++key) + ". Exit");//13

        key = 0;
    }

    private void regularPhoneSwitcher(int command) throws ClassNotFoundException {
        switch (command) {
            case 1 -> RegularPhoneService.printAll(electronics);
            case 2 -> RegularPhoneService.printShortFormInfo(electronics);
            case 3 -> RegularPhoneService.printAllAvailables(electronics);
            case 4 -> RegularPhoneService.printAllAvailablesPriceLess1000(electronics);
            case 5 -> RegularPhoneService.printAllSortedByPrice(electronics);
            case 6 -> RegularPhoneService.printOldest(electronics);
            case 7 -> RegularPhoneService.printNameOfMostExpensive(electronics);
            case 8 -> RegularPhoneService.printAllWhites(electronics);

            case 9 -> RegularPhoneService.printAllSortedByScreenSize(electronics);

            case 10 -> RegularPhoneService.printAllMonoblocks(electronics);

            case 11 -> new ServiceMenu("MobilePhone").getMenu();
            case 12 -> new MainMenu().getMenu();
            case 13 -> {
                isMenuActive = false;
                System.out.println("Thank you!");
            }
            default -> System.out.println(RED_COLOR + "Invalid command number" + RESET_COLOR);
        }
    }

    private void smartPhoneText() {
        electronicsTextFirst8Lines();

        System.out.println((++key) + ". Print all " + productType + "s sorted by screen size");// 9

        System.out.println("----------");
        System.out.println((++key) + ". Go to Upper Menu");//10
        System.out.println((++key) + ". Back to Main Menu");//11
        System.out.println((++key) + ". Exit");//12

        key = 0;
    }

    private void smartPhoneSwitcher(int command) throws ClassNotFoundException {
        switch (command) {
            case 1 -> SmartPhoneService.printAll(electronics);
            case 2 -> SmartPhoneService.printShortFormInfo(electronics);
            case 3 -> SmartPhoneService.printAllAvailables(electronics);
            case 4 -> SmartPhoneService.printAllAvailablesPriceLess1000(electronics);
            case 5 -> SmartPhoneService.printAllSortedByPrice(electronics);
            case 6 -> SmartPhoneService.printOldest(electronics);
            case 7 -> SmartPhoneService.printNameOfMostExpensive(electronics);
            case 8 -> SmartPhoneService.printAllWhites(electronics);

            case 9 -> SmartPhoneService.printAllSortedByScreenSize(electronics);

            case 10 -> new ServiceMenu("MobilePhone").getMenu();
            case 11 -> new MainMenu().getMenu();
            case 12 -> {
                isMenuActive = false;
                System.out.println("Thank you!");
            }
            default -> System.out.println(RED_COLOR + "Invalid command number" + RESET_COLOR);
        }
    }

    private void tvText() {
        electronicsTextFirst8Lines();

        System.out.println((++key) + ". Print all Smart " + productType + "s names");// 9

        System.out.println("----------");
        System.out.println((++key) + ". Go to Upper Menu");//10
        System.out.println((++key) + ". Back to Main Menu");//
        System.out.println((++key) + ". Exit");//

        key = 0;
    }

    private void tvSwitcher(int command) throws ClassNotFoundException {
        switch (command) {
            case 1 -> TVService.printAll(electronics);
            case 2 -> TVService.printShortFormInfo(electronics);
            case 3 -> TVService.printAllAvailables(electronics);
            case 4 -> TVService.printAllAvailablesPriceLess1000(electronics);
            case 5 -> TVService.printAllSortedByPrice(electronics);
            case 6 -> TVService.printOldest(electronics);
            case 7 -> TVService.printNameOfMostExpensive(electronics);
            case 8 -> TVService.printAllWhites(electronics);

            case 9 -> TVService.printAllSmartTVNames(electronics);

            case 10 -> new ServiceMenu("Electronics").getMenu();
            case 11 -> new MainMenu().getMenu();
            case 12 -> {
                isMenuActive = false;
                System.out.println("Thank you!");
            }
            default -> System.out.println(RED_COLOR + "Invalid command number" + RESET_COLOR);
        }
    }

    private void computerText() {
        electronicsTextFirst8Lines();

        System.out.println((++key) + ". Print all SSD " + productType + "s RAM less or equal 16 GB");// 9
        System.out.println("----------");
        System.out.println((++key) + ". Go to PC Service");//10
        System.out.println((++key) + ". Go to Laptop Service");//11
        System.out.println("----------");
        System.out.println((++key) + ". Go to Upper Menu");//12
        System.out.println((++key) + ". Back to Main Menu");//13
        System.out.println((++key) + ". Exit");//14

        key = 0;
    }

    private void computerSwitcher(int command) throws ClassNotFoundException {
        switch (command) {
            case 1 -> ComputerService.printAll(electronics);
            case 2 -> ComputerService.printShortFormInfo(electronics);
            case 3 -> ComputerService.printAllAvailables(electronics);
            case 4 -> ComputerService.printAllAvailablesPriceLess1000(electronics);
            case 5 -> ComputerService.printAllSortedByPrice(electronics);
            case 6 -> ComputerService.printOldest(electronics);
            case 7 -> ComputerService.printNameOfMostExpensive(electronics);
            case 8 -> ComputerService.printAllWhites(electronics);

            case 9 -> ComputerService.printSSDsRAMlessOrEqual16GB(electronics);

            case 10 -> new ServiceMenu("PC").getMenu();
            case 11 -> new ServiceMenu("Laptop").getMenu();

            case 12 -> new ServiceMenu("Electronics").getMenu();
            case 13 -> new MainMenu().getMenu();
            case 14 -> {
                isMenuActive = false;
                System.out.println("Thank you!");
            }
            default -> System.out.println(RED_COLOR + "Invalid command number" + RESET_COLOR);
        }
    }

    private void PCText() {
        electronicsTextFirst8Lines();

        System.out.println((++key) + ". Print all SSD " + productType + "s RAM less or equal 16 GB");// 9

        System.out.println("----------");
        System.out.println((++key) + ". Go to Upper Menu");//10
        System.out.println((++key) + ". Back to Main Menu");//
        System.out.println((++key) + ". Exit");//

        key = 0;
    }

    private void PCSwitcher(int command) throws ClassNotFoundException {
        switch (command) {
            case 1 -> PCService.printAll(electronics);
            case 2 -> PCService.printShortFormInfo(electronics);
            case 3 -> PCService.printAllAvailables(electronics);
            case 4 -> PCService.printAllAvailablesPriceLess1000(electronics);
            case 5 -> PCService.printAllSortedByPrice(electronics);
            case 6 -> PCService.printOldest(electronics);
            case 7 -> PCService.printNameOfMostExpensive(electronics);
            case 8 -> PCService.printAllWhites(electronics);

            case 9 -> PCService.printSSDsRAMlessOrEqual16GB(electronics);

            case 10 -> new ServiceMenu("Computer").getMenu();
            case 11 -> new MainMenu().getMenu();
            case 12 -> {
                isMenuActive = false;
                System.out.println("Thank you!");
            }
            default -> System.out.println(RED_COLOR + "Invalid command number" + RESET_COLOR);
        }
    }

    private void laptopText() {
        electronicsTextFirst8Lines();

        System.out.println((++key) + ". Print all SSD " + productType + "s RAM less or equal 16 GB");// 9

        System.out.println((++key) + ". Print all " + productType + "s buttery life more 20 hours");// 10
        System.out.println("----------");
        System.out.println((++key) + ". Go to Upper Menu");//11
        System.out.println((++key) + ". Back to Main Menu");//12
        System.out.println((++key) + ". Exit");//13

        key = 0;
    }

    private void laptopSwitcher(int command) throws ClassNotFoundException {
        switch (command) {
            case 1 -> LaptopService.printAll(electronics);
            case 2 -> LaptopService.printShortFormInfo(electronics);
            case 3 -> LaptopService.printAllAvailables(electronics);
            case 4 -> LaptopService.printAllAvailablesPriceLess1000(electronics);
            case 5 -> LaptopService.printAllSortedByPrice(electronics);
            case 6 -> LaptopService.printOldest(electronics);
            case 7 -> LaptopService.printNameOfMostExpensive(electronics);
            case 8 -> LaptopService.printAllWhites(electronics);

            case 9 -> LaptopService.printSSDsRAMlessOrEqual16GB(electronics);

            case 10 -> LaptopService.printButteryLifeMore20hours(electronics);

            case 11 -> new ServiceMenu("Computer").getMenu();
            case 12 -> new MainMenu().getMenu();
            case 13 -> {
                isMenuActive = false;
                System.out.println("Thank you!");
            }
            default -> System.out.println(RED_COLOR + "Invalid command number" + RESET_COLOR);
        }
    }

    private void householdApplianceText() {
        electronicsTextFirst8Lines();

        System.out.println((++key) + ". Print name of heavier " + productType);// 9
        System.out.println("----------");
        System.out.println((++key) + ". Go to Microwave Service");//10
        System.out.println((++key) + ". Go to WashingMachine Service");//11
        System.out.println((++key) + ". Go to Refrigerator Service");//12
        System.out.println("----------");
        System.out.println((++key) + ". Go to Upper Menu");//13
        System.out.println((++key) + ". Back to Main Menu");//14
        System.out.println((++key) + ". Exit");//15

        key = 0;
    }

    private void householdApplianceSwitcher(int command) throws ClassNotFoundException {
        switch (command) {
            case 1 -> HouseholdApplianceService.printAll(electronics);
            case 2 -> HouseholdApplianceService.printShortFormInfo(electronics);
            case 3 -> HouseholdApplianceService.printAllAvailables(electronics);
            case 4 -> HouseholdApplianceService.printAllAvailablesPriceLess1000(electronics);
            case 5 -> HouseholdApplianceService.printAllSortedByPrice(electronics);
            case 6 -> HouseholdApplianceService.printOldest(electronics);
            case 7 -> HouseholdApplianceService.printNameOfMostExpensive(electronics);
            case 8 -> HouseholdApplianceService.printAllWhites(electronics);

            case 9 -> HouseholdApplianceService.printNameOfHeavier(electronics);

            case 10 -> new ServiceMenu("Microwave").getMenu();
            case 11 -> new ServiceMenu("WashingMachine").getMenu();
            case 12 -> new ServiceMenu("Refrigerator").getMenu();

            case 13 -> new ServiceMenu("Electronics").getMenu();
            case 14 -> new MainMenu().getMenu();
            case 15 -> {
                isMenuActive = false;
                System.out.println("Thank you!");
            }
            default -> System.out.println(RED_COLOR + "Invalid command number" + RESET_COLOR);
        }
    }

    private void microwaveText() {
        electronicsTextFirst8Lines();

        System.out.println((++key) + ". Print name of heavier " + productType);// 9

        System.out.println("----------");
        System.out.println((++key) + ". Go to Upper Menu");//10
        System.out.println((++key) + ". Back to Main Menu");//11
        System.out.println((++key) + ". Exit");//12

        key = 0;
    }

    private void microwaveSwitcher(int command) throws ClassNotFoundException {
        switch (command) {
            case 1 -> MicrowaveService.printAll(electronics);
            case 2 -> MicrowaveService.printShortFormInfo(electronics);
            case 3 -> MicrowaveService.printAllAvailables(electronics);
            case 4 -> MicrowaveService.printAllAvailablesPriceLess1000(electronics);
            case 5 -> MicrowaveService.printAllSortedByPrice(electronics);
            case 6 -> MicrowaveService.printOldest(electronics);
            case 7 -> MicrowaveService.printNameOfMostExpensive(electronics);
            case 8 -> MicrowaveService.printAllWhites(electronics);

            case 9 -> MicrowaveService.printNameOfHeavier(electronics);

            case 10 -> new ServiceMenu("HouseholdAppliance").getMenu();
            case 11 -> new MainMenu().getMenu();
            case 12 -> {
                isMenuActive = false;
                System.out.println("Thank you!");
            }
            default -> System.out.println(RED_COLOR + "Invalid command number" + RESET_COLOR);
        }
    }

    private void washingMachineText() {
        electronicsTextFirst8Lines();

        System.out.println((++key) + ". Print name of heavier " + productType);// 9

        System.out.println((++key) + ". Print " + productType + "s in descending order by RPM");// 10

        System.out.println("----------");
        System.out.println((++key) + ". Go to Upper Menu");//11
        System.out.println((++key) + ". Back to Main Menu");//12
        System.out.println((++key) + ". Exit");//13

        key = 0;
    }

    private void washingMachineSwitcher(int command) throws ClassNotFoundException {
        switch (command) {
            case 1 -> WashingMachineService.printAll(electronics);
            case 2 -> WashingMachineService.printShortFormInfo(electronics);
            case 3 -> WashingMachineService.printAllAvailables(electronics);
            case 4 -> WashingMachineService.printAllAvailablesPriceLess1000(electronics);
            case 5 -> WashingMachineService.printAllSortedByPrice(electronics);
            case 6 -> WashingMachineService.printOldest(electronics);
            case 7 -> WashingMachineService.printNameOfMostExpensive(electronics);
            case 8 -> WashingMachineService.printAllWhites(electronics);

            case 9 -> WashingMachineService.printNameOfHeavier(electronics);
            case 10 -> WashingMachineService.printinDescendingRPMOrder(electronics);

            case 11 -> new ServiceMenu("HouseholdAppliance").getMenu();
            case 12 -> new MainMenu().getMenu();
            case 13 -> {
                isMenuActive = false;
                System.out.println("Thank you!");
            }
            default -> System.out.println(RED_COLOR + "Invalid command number" + RESET_COLOR);
        }
    }

    private void refrigeratorText() {
        electronicsTextFirst8Lines();

        System.out.println((++key) + ". Print name of heavier " + productType);// 9

        System.out.println((++key) + ". Print name of higher" + productType);// 10

        System.out.println("----------");
        System.out.println((++key) + ". Go to Upper Menu");//11
        System.out.println((++key) + ". Back to Main Menu");//12
        System.out.println((++key) + ". Exit");//13

        key = 0;
    }

    private void refrigeratorSwitcher(int command) throws ClassNotFoundException {
        switch (command) {
            case 1 -> RefrigeratorService.printAll(electronics);
            case 2 -> RefrigeratorService.printShortFormInfo(electronics);
            case 3 -> RefrigeratorService.printAllAvailables(electronics);
            case 4 -> RefrigeratorService.printAllAvailablesPriceLess1000(electronics);
            case 5 -> RefrigeratorService.printAllSortedByPrice(electronics);
            case 6 -> RefrigeratorService.printOldest(electronics);
            case 7 -> RefrigeratorService.printNameOfMostExpensive(electronics);
            case 8 -> RefrigeratorService.printAllWhites(electronics);

            case 9 -> RefrigeratorService.printNameOfHeavier(electronics);

            case 10 -> RefrigeratorService.printNameOFHigher(electronics);

            case 11 -> new ServiceMenu("HouseholdAppliance").getMenu();
            case 12 -> new MainMenu().getMenu();
            case 13 -> {
                isMenuActive = false;
                System.out.println("Thank you!");
            }
            default -> System.out.println(RED_COLOR + "Invalid command number" + RESET_COLOR);
        }
    }


}
