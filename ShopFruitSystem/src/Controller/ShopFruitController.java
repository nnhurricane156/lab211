package Controller;

import Model.Fruit;
import View.Menu;
import View.ShopFruitView;

import java.lang.management.MemoryNotificationInfo;
import java.util.ArrayList;

public class ShopFruitController extends Menu {
    ShopFruitView shopFruitView = new ShopFruitView();
    private ArrayList<Fruit> fruitList = new ArrayList<>();

    public ShopFruitController() {
        super("SHOP FRUIT SYSTEM",new String[]{
                "Create Fruit", "View Orders", "Shopping (for buyers)", "Exit"
        });
        shopFruitView.loadData(fruitList);
    }

    @Override
    public void execute(int choice) {
        switch (choice){
        }
    }

}
