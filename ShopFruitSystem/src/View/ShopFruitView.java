package View;

import Common.Inputter;
import Common.Validation;
import Model.Fruit;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ShopFruitView {
    Inputter inputter = new Inputter();

    public void loadData(ArrayList<Fruit> sList) {
        try {
            Validation vd = new Validation();
            BufferedReader br = new BufferedReader(new FileReader("Input.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split("\\|");
                if (arr.length == 5) {
                    boolean isId = vd.isValid(arr[0], "[0-9]{1,}"),
                            isName = vd.isName(arr[1]),
                            isPrice = vd.isPrice(arr[2]),
                            isQuantity = vd.isQuantity(arr[3]),
                            isOrigin = vd.isOrigin(arr[4]);

                    if (isId && isName && isPrice && isQuantity && isOrigin) {
                        String id = arr[0],
                                name = arr[1];
                        Double price = vd.getPrice(arr[2]);
                        Long quantity = vd.getQuantity(arr[3]);
                        String origin = arr[4];
                        Fruit st = new Fruit(id, name, price, quantity, origin);
                        sList.add(st);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        display(sList);
    }

    public void display(ArrayList<Fruit> sList) {
        System.out.println("=========FRUIT'S LIST===========");
        for (Fruit st : sList) {
            System.out.println(st.toString());
        }
    }

    public void createFruit(ArrayList<Fruit> fruitsList) {
        do {
            String id = inputter.inputPattern("Fruit ID", "\\d+"),
                    name = inputter.getString("Fruit Name"),
                    origin = inputter.getString("Origin");
            Double price = inputter.getDouble("Price: ");
            Long quantity = inputter.getLong("Quantity");
        }while ()
    }

    public boolean optionalMenu(String data){
        char choice = inputter.getString(data);
        System.out.println();
    }
}
