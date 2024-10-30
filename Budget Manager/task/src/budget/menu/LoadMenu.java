package budget.menu;

import budget.Purchase;
import budget.TransactionFile;
import budget.TransactionManager;

public class LoadMenu {
    private final TransactionManager manager;

    public LoadMenu(TransactionManager manager) {
        this.manager = manager;
    }

    public void show() {
        TransactionFile transactionFile = new TransactionFile(manager.getPurchases());
        transactionFile.load(manager);
        System.out.println("\nPurchases were loaded!\n");

//        for (Purchase purchase : transactionFile.getPurchases()) {
//            manager.addPurchase(purchase);
    }
}
