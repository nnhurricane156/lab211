package Common;

import java.util.Scanner;

public class Inputter {
    Scanner scanner = new Scanner(System.in);
    public double getDouble(String name){
        while (true){
            try{
                System.out.printf("Enter %s: ",name);
                String num = scanner.nextLine();
                return Double.parseDouble(num);
            } catch (Exception e){
                System.out.println("Wrong format !!!");
                e.printStackTrace();
            }
        }
    }

    public String getString(String name){
        while (true){
            System.out.printf("Enter %s: ",name);
            String txt = scanner.nextLine();
            if(!txt.isEmpty())
                return txt;
        }
    }
}
