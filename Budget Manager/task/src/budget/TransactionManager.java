package budget;

import budget.utility.KeyboardUtil;

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

    public void addPurchase(Purchase purchase) {
        this.purchases.add(purchase);
        this.totalExpenses += purchase.getPrice();
    }

    public void registerPurchase(Purchase purchase) {
        addPurchase(purchase);
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

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void printPurchases() {

            System.out.println("\nPurchase list:");
            for (Purchase purchase : purchases) {
                System.out.println(purchase);
            }
            System.out.println("Total sum: $" + totalExpenses);

    }

    public void getPurchasesByType(PurchaseType type) {
        ArrayList<Purchase> purchasesByType = new ArrayList<>();
        purchases.stream()
                .filter(p -> p.getType().equals(type))
                .forEach(purchasesByType::add);
        if (purchasesByType.isEmpty()) {
            System.out.println("\nPurchase list is empty!");
        } else {
            System.out.println("\n" + type.getName() + ":");
            purchasesByType.forEach(System.out::println);
            System.out.println("Total sum: $" + purchasesByType.stream().mapToDouble(Purchase::getPrice).sum());
        }
    }

    public boolean hasPurchases() {
        return !purchases.isEmpty();
    }


    public void sortAll() {
        if (!hasPurchases()) {
            System.out.println("\nPurchase list is empty!");
            return;
        }
        purchases.sort((p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()));
        printPurchases();
    }

    public void sortCertainType() {
        System.out.println("\nChoose the type of purchase");
        for (PurchaseType purchaseType : PurchaseType.values()) {
            System.out.println(purchaseType.ordinal() + 1 + ") " + purchaseType.getName());
        }
        int purchaseTypeChoice = KeyboardUtil.getInputInt();
        PurchaseType type = PurchaseType.values()[purchaseTypeChoice - 1];
        getPurchasesByType(type);
    }

    public void sortByType() {
        System.out.println("\n");
        ArrayList<Purchase> totalPurchasesByType = new ArrayList<>();
        for (PurchaseType purchaseType : PurchaseType.values()) {
            ArrayList<Purchase> purchasesByType = new ArrayList<>();
            purchases.stream()
                    .filter(p -> p.getType().equals(purchaseType))
                    .forEach(purchasesByType::add);
            double sumByType = purchasesByType.stream().mapToDouble(Purchase::getPrice).sum();
            totalPurchasesByType.add(new Purchase(purchaseType.getName(), sumByType, purchaseType));

        }
        totalPurchasesByType.sort((p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()));
        for (Purchase purchase : totalPurchasesByType) {
            String output = "%s - $%.2f".formatted(purchase.getName(), purchase.getPrice());
            System.out.println(output);
        }

    }
}
