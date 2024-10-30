package budget;

public enum PurchaseType {
    FOOD("Food"),
    CLOTHES("Clothes"),
    ENTERTAINMENT("Entertainment"),
    OTHER("Other");

    private final String name;

    PurchaseType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
