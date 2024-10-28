package budget;

import budget.Utility.KeyboardUtil;

public class PurchaseMenu {
    private final TransactionManager manager;

    public PurchaseMenu(TransactionManager manager) {
        this.manager = new TransactionManager();
    }

    public void show() {
        System.out.println("\nChoose the type of purchase\n");
        for (PurchaseType purchaseType : PurchaseType.values()) {
            System.out.println(purchaseType.ordinal() + 1 + ") " + purchaseType.getName());
        }
        int purchaseTypeChoice = KeyboardUtil.getInputInt("");
        PurchaseType type = PurchaseType.values()[purchaseTypeChoice - 1];
        AddPurchase addPurchase = new AddPurchase(manager, type);
        addPurchase.purchaseInput();

    }

}
