package Model;

import java.util.Objects;

public class Fruit {
    private Integer id;
    private String name, origin;
    private static Integer nextId = 0;
    private int quantity;
    private double price;

    public Fruit(String name, String origin, double price, int quantity) {
        this.id = ++nextId;
        this.name = name;
        this.origin = origin;
        this.price = price;
        this.quantity = quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public static void setNextId(Integer nextId) {
        Fruit.nextId = nextId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + "\t" + name + "\t" + origin + "\t" + price +"$" + "\t" + quantity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fruit)) return false;
        Fruit fruit = (Fruit) o;
        return Double.compare(fruit.price, price) == 0 && Objects.equals(name, fruit.name) && Objects.equals(origin, fruit.origin);
    }

}
