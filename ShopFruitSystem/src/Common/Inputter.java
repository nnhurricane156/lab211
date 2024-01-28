package Common;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Scanner;

public class Inputter {
    public String getString(String name) {
        Scanner sc = new Scanner(System.in);
        String s = null;
        while (s == null || s.isEmpty()) {
            System.out.print(String.format("Enter %s: ", name));
            s = sc.nextLine();
        }
        return s;
    }

    public String inputPattern(String name, String pattern) {
        Scanner sc = new Scanner(System.in);
        String s = null;
        do {
            System.out.print(String.format("Enter %s: ", name));
            s = sc.nextLine();
        } while (s == null || s.isEmpty() || !s.matches(pattern));
        return s;
    }

    public Double getDouble(String name){
        Scanner sc = new Scanner(System.in);
        Double num;
        do{
            System.out.printf("Enter %s: ",name);
            num = sc.nextDouble();
        } while (num == null || num.isNaN());
        return num;
    }

    public Long getLong(String name){
        Scanner sc = new Scanner(System.in);
        Long num;
        do{
            System.out.printf("Enter %s: ",name);
            num = sc.nextLong();
        } while (num == null);
        return num;
    }

    public char getChar(String data){
        Scanner sc = new Scanner(System.in);
        char c;
        do{
            System.out.printf("Enter %s: ",data);
            c = sc.ne;
        }
    }
}
