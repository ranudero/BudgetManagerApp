package budget.menu;

import budget.TransactionFile;
import budget.TransactionManager;

public class SaveMenu {
    private final TransactionManager manager;

    public SaveMenu(TransactionManager manager) {
        this.manager = manager;
    }

    public void show() {
        TransactionFile transactionFile = new TransactionFile(manager.getPurchases());
        transactionFile.save();
        System.out.println("\nPurchases were saved!\n");
    }
}
