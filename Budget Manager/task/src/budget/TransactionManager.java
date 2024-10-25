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

    public double getTotalExpenses() {
        return totalExpenses;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void getPurchases() {
        if (purchases.isEmpty()) {
            System.out.println("\nPurchase list is empty");
        } else {
            System.out.println("\nPurchase list:");
            for (Purchase purchase : purchases) {
                System.out.print(purchase.getName());
                System.out.print(" $");
                System.out.println(purchase.getPrice());
            }
            System.out.println("Total sum: $" + totalExpenses);
        }

    }
}
