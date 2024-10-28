package budget;

import budget.Utility.KeyboardUtil;

public class AddPurchase {

    private final TransactionManager manager;
    private final PurchaseType type;

    public AddPurchase(TransactionManager manager, PurchaseType type) {
        this.manager = manager;
        this.type = type;
    }

    public void purchaseInput(){

        String purchaseName = KeyboardUtil.getInputString("\nEnter purchase name:");
        double purchasePrice = KeyboardUtil.getInputDouble("Enter its price:");

        Purchase purchase = new Purchase(purchaseName, purchasePrice, type);
        manager.registerPurchase(purchase);

    }
}
