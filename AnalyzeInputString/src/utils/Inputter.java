/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class Inputter {

    private final Scanner sc = new Scanner(System.in);

    public String getString(String msg) {
        System.out.print(msg + ": ");
        return sc.nextLine();
    }

    public long getNum(String msg) {
        long nLong = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                System.out.print(msg + ": ");
                String n = sc.nextLine();
                nLong = Long.parseLong(n);
                isValidInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Phone number must is number");
            }
        }
        return nLong;
    }

    public double getDouble(String msg) {
        double nInt = 0;
        try {
            System.out.print(msg + ": ");
            String n = sc.nextLine();
            nInt = Double.parseDouble(n);
        } catch (NumberFormatException e) {            
            return 0;
        }

        return nInt;
    }

    public int getIntAcceptEnter(String msg) {
        int nInt = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                System.out.print(msg + ": ");
                String input = sc.nextLine();

                // If the input is empty, consider it valid and break the loop
                if (input.trim().isEmpty()) {
                    isValidInput = true;
                } else {
                    nInt = Integer.parseInt(input);
                    isValidInput = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        return nInt;
    }

    public int getIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    public double getDoubleLimit(double min) {
        while (true) {
            try {
                double result = Double.parseDouble(sc.nextLine().trim());
                if (result < min) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please input salary > 0");
                System.out.print("Enter again: ");
            }
        }
    }

    public String getStringNotEmpty(String msg) {
        //loop until user input correct
        while (true) {
            System.out.print(msg + ": ");
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

}
