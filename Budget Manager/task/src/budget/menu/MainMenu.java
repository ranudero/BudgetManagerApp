package budget.menu;

import budget.TransactionManager;
import budget.utility.KeyboardUtil;

import java.util.Scanner;

public class MainMenu {
    private final TransactionManager manager;
    private final PurchaseMenu purchaseMenu;
    private final ListOfPurchasesMenu listOfPurchasesMenu;
    private final SaveMenu saveMenu;

    public MainMenu() {
        manager = new TransactionManager();
        purchaseMenu = new PurchaseMenu(manager);
        listOfPurchasesMenu = new ListOfPurchasesMenu(manager);
        saveMenu = new SaveMenu(manager);

    }

    public void show() {
        System.out.println("\nChoose your action:");
        System.out.println("1) Add income");
        System.out.println("2) Add purchase");
        System.out.println("3) Show list of purchases");
        System.out.println("4) Balance");
        System.out.println("5) Save");
        System.out.println("6) Load");
        System.out.println("0) Exit");
        handleUserInput();
    }

    private void handleUserInput() {
        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();

        switch (userInput) {
            case 1:
                double income = KeyboardUtil.getInputDouble("\nEnter income:");
                manager.registerIncome(income);
                break;
            case 2:
                purchaseMenu.show();
                break;
            case 3:
                listOfPurchasesMenu.show();
                break;
            case 4:
                System.out.println("\nBalance: $" + manager.getBalance());
                break;
            case 5:
                saveMenu.show();
                break;
            case 0:
                exitApplication();
                break;
            default:
                System.out.println("Invalid input");
                break;
        }

    }

    private void exitApplication() {
        System.out.println("\nBye!");
        System.exit(0);

    }
}
