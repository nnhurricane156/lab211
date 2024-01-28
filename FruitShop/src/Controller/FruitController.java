package Controller;

import Model.Fruit;
import Model.Order;
import View.FruitView;
import View.Menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class FruitController extends Menu {
    private ArrayList<Fruit> fList = new ArrayList<>();
    private Hashtable<String, Order> oList = new Hashtable<>();
    private FruitView fView = new FruitView();

    public FruitController() {
        super("FRUIT SHOP SYSTEM", new String[] {
                "Create Fruit", "View Orders", "Shopping", "Exit"
        });
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                fView.createFruit(fList);
                break;
            case 2:
                fView.viewOrder(oList);
                break;
            case 3:
                fView.shopping(fList,oList);
                break;
            default:
                System.out.println("Thank you <3");
        }
    }
}
