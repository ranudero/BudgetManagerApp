package budget;

import java.util.ArrayList;

public class TransactionManager {

    private double balance;
    private double totalExpenses;
    private double totalIncome;
    private ArrayList<Purchase> purchases;

    public TransactionManager() {
        this.balance = 0;
        this.totalExpenses = 0;
        this.totalIncome = 0;
        this.purchases = new ArrayList<>();
    }

    public ArrayList<Purchase> getPurchases() {
        return purchases;
    }

    public void registerPurchase(Purchase purchase) {
        this.purchases.add(purchase);
        this.totalExpenses += purchase.getPrice();
        this.balance -= purchase.getPrice();
        System.out.println("Purchase was added!");
    }

    public void registerIncome(double income) {
        this.totalIncome += income;
        this.balance += income;
        System.out.println("Income was added!");
    }

    public double getBalance() {
        return balance;
    }

    public void printPurchases() {

            System.out.println("\nPurchase list:");
            for (Purchase purchase : purchases) {
                System.out.print(purchase.getName());
                System.out.print(" $");
                System.out.println(purchase.getPrice());
            }
            System.out.println("Total sum: $" + totalExpenses);

    }

    public void getPurchasesByType(PurchaseType type) {
        ArrayList<Purchase> purchasesByType = new ArrayList<>();
        for (Purchase purchase : purchases) {
            if (purchase.getType() == type) {
                purchasesByType.add(purchase);
            }
        }
        if (purchasesByType.isEmpty()) {
            System.out.println("\nPurchase list is empty!");
        } else {
            System.out.println("\n" + type.getName() + ":");
            for (Purchase purchase : purchasesByType) {
                System.out.print(purchase.getName());
                System.out.print(" $");
                System.out.println(purchase.getPrice());
            }
            System.out.println("Total sum: $" + purchasesByType.stream().mapToDouble(Purchase::getPrice).sum());
        }
    }

    public boolean hasPurchases() {
        return !purchases.isEmpty();
    }


}
