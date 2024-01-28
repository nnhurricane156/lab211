package Model;

public class Order {
    private String fName;
    int quantity;
    double price;
    private double amount;

    public Order(String fName, int quantity, double price) {
        this.fName = fName;
        this.quantity = quantity;
        this.price = price;
    }
    public Double getAmount() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return  fName + "\t" + quantity + "\t" + price + "$" + "\t" + getAmount() + "$" +
                "\n" + "Total: " + getAmount() + "$";
    }
}
