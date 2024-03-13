package Common;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Inputter {
    Validation validation = new Validation();
    Scanner scanner = new Scanner(System.in);

    public String getString(String name) {
        String s = null;
        while (s == null || s.isEmpty()) {
            System.out.printf("Enter %s: ", name);
            s = scanner.nextLine();
            if (s.isEmpty())
                System.out.println("Can not be null !!!");
        }
        return s;
    }

    public String getPhone() {
        String s = null;
        do {
            System.out.print("Enter Phone: ");
            s = scanner.nextLine();
            if (s.isEmpty())
                System.out.print("Phone can not be empty !!!");
            else if (validation.checkPhone(s) == 0) {
                return s;
            } else if (validation.checkPhone(s) == 2) {
                System.out.println("Phone number must is number !!!");
            } else
                System.out.println("Phone number must be 10 digits");
        } while (true);
    }

    public String getEmail() {
        String s = null;
        do {
            System.out.print("Enter Email: ");
            s = scanner.nextLine();
            if (validation.checkEmail(s))
                return s;
            else
                System.out.println("Email must is correct format");
        } while (true);
    }

    public Date getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter date : ");
            String dateString = scanner.nextLine();

            try {
                date = formatter.parse(dateString);
                validInput = true;
            } catch (ParseException e) {
                System.out.println("Date to correct format(dd/mm/yyyy) ");
            }
        }
        return date;
    }
}
