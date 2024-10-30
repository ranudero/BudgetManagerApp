package budget;

import java.io.*;
import java.util.ArrayList;

public class TransactionFile {
    private static final String FILE_NAME = "purchases.txt";
    private final ArrayList<Purchase> purchases;

    public TransactionFile(ArrayList<Purchase> purchases) {
        this.purchases = purchases;
    }

    public void save(TransactionManager manager) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            // Write the balance as the first line
            writer.write(manager.getBalance() + "\n");
            for (Purchase purchase : purchases) {
                writer.write(purchase.getName() + "\n");
                writer.write(purchase.getPrice() + "\n");
                writer.write(purchase.getType() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving purchases to file: " + e.getMessage());
        }
    }

    public void load(TransactionManager manager) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            // Clear current purchases
            purchases.clear();

            // Read and set the balance
            String balanceLine = reader.readLine();
            if (balanceLine != null) {
                manager.setBalance(Double.parseDouble(balanceLine));
            }

            // Read purchases
            String name;
            while ((name = reader.readLine()) != null) {
                double price = Double.parseDouble(reader.readLine());
                PurchaseType type = PurchaseType.valueOf(reader.readLine());
                Purchase purchase = new Purchase(name, price, type);
                manager.addPurchase(purchase);
            }
        } catch (IOException e) {
            System.out.println("Error loading purchases from file: " + e.getMessage());
        }
    }


    public ArrayList<Purchase> getPurchases() {
        return purchases;
    }
}
