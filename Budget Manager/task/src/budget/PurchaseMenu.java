package budget;

import budget.Utility.KeyboardUtil;

public class PurchaseMenu {
    private final TransactionManager manager;

    public PurchaseMenu(TransactionManager manager) {
        this.manager = manager;
    }

    public void show() {
        while(true) {
            System.out.println("\nChoose the type of purchase");
            for (PurchaseType purchaseType : PurchaseType.values()) {
                System.out.println(purchaseType.ordinal() + 1 + ") " + purchaseType.getName());
            }
            System.out.println("5) Back");
            int purchaseTypeChoice = KeyboardUtil.getInputInt();
            if (purchaseTypeChoice == 5) {
                return;
            }
            PurchaseType type = PurchaseType.values()[purchaseTypeChoice - 1];
            AddPurchase addPurchase = new AddPurchase(manager, type);
            addPurchase.purchaseInput();
        }

    }

}
