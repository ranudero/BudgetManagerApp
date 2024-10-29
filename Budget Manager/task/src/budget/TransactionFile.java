package budget;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class TransactionFile {
    private static final String FILE_NAME = "purchases.txt";
    private final ArrayList<Purchase> purchases;

    public TransactionFile(ArrayList<Purchase> purchases) {
        this.purchases = purchases;
    }

    public void save() {
        // write purchases to file
        try (FileWriter file = new FileWriter(FILE_NAME);
             BufferedWriter writer = new BufferedWriter(file)) {
            for (Purchase purchase : purchases) {
                writer.write(purchase.getName() + "\n");
                writer.write(purchase.getPrice() + "\n");
                writer.write(purchase.getType().getName() + "\n");
            }
        } catch (Exception e) {
            System.out.println("Error saving purchases to file: " + e.getMessage());
        }

    }
}
