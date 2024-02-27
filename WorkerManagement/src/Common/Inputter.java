package Common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Inputter {
    Scanner scanner = new Scanner(System.in);

    public long getLong(String name) {
        while (true) {
            try {
                System.out.print("Enter " + name + " :");
                String num = scanner.nextLine();
                return Long.parseLong(num);
            } catch (NumberFormatException e) {
                System.out.println("Wrong Format !!!");
            }
        }
    }

    public String getString(String name) {
        while (true) {
            System.out.printf("Enter %s:",name);
            String txt = scanner.nextLine();
            if (!txt.isEmpty())
                return txt;
            else
                System.out.println("Empty !!!");
        }
    }

    public String getCode(String name) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.printf("Enter %s: ", name);
            String txt = scanner.nextLine();
            if (!txt.isEmpty() && txt.matches("[A-Z]\\s?\\d+")) {
                return txt;
            } else {
                System.out.println("Wrong Code Format !!!");
            }
        }
    }


    public int getAge(String name){
        while (true){
            try {
                System.out.printf("Enter %s:",name);
                String num = scanner.nextLine();
                int age = Integer.parseInt(num);
                if(age >= 18 && age <=50)
                    return age;
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Inputter inputter = new Inputter();
        inputter.getLong("phong");
    }
}
