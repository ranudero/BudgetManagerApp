package budget;

import budget.Utility.KeyboardUtil;

import java.util.List;

public class ListOfPurchasesMenu {
    private final TransactionManager manager;

    public ListOfPurchasesMenu(TransactionManager manager) {
        this.manager = manager;
    }

    public void show() {
        if (!manager.hasPurchases()) {
            showNoPurchases();
            return;
        }

        boolean keepGoing = true;
        while(keepGoing) {
            System.out.println("\nChoose the type of purchase");
            for (PurchaseType purchaseType : PurchaseType.values()) {
                System.out.println(purchaseType.ordinal() + 1 + ") " + purchaseType.getName());
            }
            System.out.println("5) All");
            System.out.println("6) Back");
            int purchaseTypeChoice = KeyboardUtil.getInputInt();
            switch (purchaseTypeChoice) {
                case 1, 2, 3, 4: {
                    PurchaseType type = PurchaseType.values()[purchaseTypeChoice - 1];
                    manager.getPurchasesByType(type);
                    break;
                }
                case 5:
                    showAll();
                    break;
                case 6:
                    keepGoing = false;
                    break;
            }
        }
    }

    public void showAll() {
        manager.getPurchases();
    }

    private void showNoPurchases() {
        System.out.println("\nPurchase list is empty");
    }

}
