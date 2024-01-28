package View;

import Common.Inputter;
import Model.Fruit;
import Model.Order;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class FruitView {
    private final Inputter input = new Inputter();
    private final Scanner sc = new Scanner(System.in);
    public void createFruit(ArrayList<Fruit> fList) {
        String fName = input.getName("fruit name"),
                origin = input.getName("origin");
        double price = input.getDouFromInput("price");
        int quantity = input.getIntFromInput("quantity");
        Fruit newF = new Fruit(fName, origin, price, quantity);
        int flag = 0;
        for (Fruit f : fList) {
            if (f.equals(newF)) {
                System.out.println("Existed product");
                Fruit.setNextId(newF.getId()-1);
                flag = 1;
            }
        }
        if (flag == 0)
            fList.add(newF);
        display(fList);
    }
    private boolean yesNo(String s) {
        System.out.println(s);
        String choice = input.inputPatter("your choice: ", "[yYnN]{1}");
        if (choice.equalsIgnoreCase("Y"))
            return true;
        return false;
    }
    public void shopping(ArrayList<Fruit> fList, Hashtable<String, Order> oList) {
        Scanner sc = new Scanner(System.in);
        int flag = 0;
        do {
            display(fList);
            System.out.println("You selected: ");
            int choose = sc.nextInt();
            for (Fruit f : fList) {
                if (f.getId() == choose) {
                    int quantity = input.getIntFromInput("quantity");
                    if (quantity > f.getQuantity()) {
                        System.out.println("Sold out!");
                        break;
                    }
                    if (yesNo("Do you want to order now (Y/N).")) {
                        Order newOrder = new Order(f.getName(), quantity, f.getPrice());
                        f.setQuantity(f.getQuantity() - quantity);
                        System.out.println(newOrder);
                        String sName = input.getName("customer name");
                        oList.put(sName, newOrder);
                    } else {
                        flag = 1;
                    }
                    break;
                }
            }
        } while (flag == 1);
    }
    public void viewOrder(Hashtable<String, Order> oList) {
        oList.forEach((key, value) -> {
            System.out.println("Customer: " + key);
            System.out.println("Product | Quantity | Price | Amount");
            System.out.println(value.toString());
        });
    }
    private void display(ArrayList<Fruit> fList) {
        System.out.println("List of Fruit:");
        System.out.println("Item | Fruit Name | Origin | Price | Quantity \t");
        for (Fruit f : fList) {
            System.out.println(f);
        }
    }
}
