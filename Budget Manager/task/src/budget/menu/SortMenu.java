package budget.menu;

import budget.TransactionManager;
import budget.utility.KeyboardUtil;

public class SortMenu {
    private final TransactionManager manager;

    public SortMenu(TransactionManager manager) {
        this.manager = manager;
    }

    public void show() {

        boolean keepGoing = true;
        while (keepGoing) {
            printMenu();
            int choice = KeyboardUtil.getInputInt();
            switch (choice) {
                case 1:
                    sortAll();
                    break;
                case 2:
                    sortByType();
                    break;
                case 3:
                    sortCertainType();
                    break;
                case 4:
                    keepGoing = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }

    }

    private void sortByType() {
        manager.sortByType();
    }

    private void printMenu() {
        System.out.println("\nHow do you want to sort?");
        System.out.println("1) Sort all purchases");
        System.out.println("2) Sort by type");
        System.out.println("3) Sort certain type");
        System.out.println("4) Back");
    }

    private void sortAll() {
        manager.sortAll();
    }

    private void sortCertainType() {
        manager.sortCertainType();
    }
}
