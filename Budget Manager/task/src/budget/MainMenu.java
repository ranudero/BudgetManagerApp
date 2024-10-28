package budget;

import budget.Utility.KeyboardUtil;

import java.util.Scanner;

public class MainMenu {
    private final TransactionManager manager;

    public MainMenu() {
        manager = new TransactionManager();
    }

    public void show() {
        System.out.println("\nChoose your action:");
        System.out.println("1) Add income");
        System.out.println("2) Add purchase");
        System.out.println("3) Show list of purchases");
        System.out.println("4) Balance");
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
                AddPurchase addPurchase = new AddPurchase(manager);
                addPurchase.purchaseInput();
                break;
            case 3:
                manager.getPurchases();
                break;
            case 4:
                System.out.println("\nBalance: $" + manager.getBalance());
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
