package Common;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Inputter {
    public int getIntFromInput(String name) {
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            System.out.print(String.format("Enter %s: ", name));
            try {
                number = sc.nextInt();
                if (number > 0) {
                    return number;
                } else {
                    System.out.println("Please enter the integer number > 0");
                }
            } catch (InputMismatchException e) {
                System.out.println("Only enter the integer number > 0 ");
                sc.next();
            }
        }
    }
    public double getDouFromInput(String name) {
        Scanner sc = new Scanner(System.in);
        double number;
        while (true) {
            System.out.print(String.format("Enter %s: ", name));
            try {
                number = sc.nextDouble();
                if (number >= 0) {
                    return number;
                } else {
                    System.out.println("Please enter the number > 0 ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Only enter the integer number > 0 ");
                sc.next();
            }
        }
    }
    public String getName(String name) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = null;
        String s = null;
        while (s == null || s.isEmpty()) {
            System.out.print(String.format("Enter %s: ", name));
            s = sc.nextLine();
            sb = new StringBuilder(s);
            if (Character.isLowerCase(sb.charAt(0))) {
                sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
            }
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == ' ')
                    sb.delete(i,i+1);
            }
        }
        return sb.toString();
    }

    public String getString(String name) {
        Scanner sc = new Scanner(System.in);
        String s = null;
        while (s == null || s.isEmpty()) {
            System.out.print(String.format("Enter %s: ", name));
            s = sc.nextLine();
        }
        return s;
    }

    public String inputPatter(String name, String pattern) {
        Scanner sc = new Scanner(System.in);
        String s = null;
        do {
            System.out.print(String.format("Enter %s: ", name));
            s = sc.nextLine();
        } while (s == null || s.isEmpty() || !s.matches(pattern));
        return s;
    }

}
