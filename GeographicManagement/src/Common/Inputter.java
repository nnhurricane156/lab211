package Common;

import java.util.Scanner;

public class Inputter {
    Scanner scanner = new Scanner(System.in);

    public String getStringData(String name) {
        do {
            try {
                System.out.printf("Enter %10s: ", name);
                String data = scanner.nextLine();
                if (!data.isEmpty()) {
                    return data;
                }
            } catch (Exception e) {
                System.out.println("Error !!!!");
            }
        } while (true);
    }

    public float getFloatData(String name) {
        do {
            try {
                System.out.printf("Enter %s: ", name);
                String data = scanner.nextLine();
                float num = Float.parseFloat(data);

                if (num > 0) {
                    return num;
                } else {
                    System.out.println("Please enter a positive number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid Data. Please enter a valid number.");
            }
        } while (true);
    }
}
