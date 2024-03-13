package Common;

import Model.En;

import java.util.Scanner;

public class Inputter {
    Scanner scanner = new Scanner(System.in);
    Validation validation = new Validation();

    public String getAccountNumber(String name,String error) {
        while (true) {
            System.out.print(name+ " : ");
            String num = scanner.nextLine();
            if (validation.checkAccountNumber(num)) {
                return num;
            }
            else
                System.out.printf(error);
        }
    }

    public String getPassword(String name,String error) {
        while (true) {
            System.out.println(name +" : ");
            String pass = scanner.nextLine();
            if (validation.checkPassword(pass)) {
                return pass;
            }
            else
                System.out.printf(error);
        }
    }
}
