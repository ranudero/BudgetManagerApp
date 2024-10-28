package budget;

import budget.Utility.KeyboardUtil;

public class AddPurchase {

    private final TransactionManager manager;

    public AddPurchase(TransactionManager manager) {
        this.manager = manager;
    }

    public void purchaseInput(){

        String purchaseName = KeyboardUtil.getInputString("\nEnter purchase name:");
        double purchasePrice = KeyboardUtil.getInputDouble("Enter its price:");

        Purchase purchase = new Purchase(purchaseName, purchasePrice);

        //TODO ADD PURCHASE TO THE LIST
        manager.registerPurchase(purchase);

    }
}
