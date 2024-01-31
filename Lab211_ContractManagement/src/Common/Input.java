/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

    Scanner sc = new Scanner(System.in);
    SimpleDateFormat dateFormat = new SimpleDateFormat();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public String inputString(String str) {
        String s = "";
        int dem = 0;
        System.out.println(str);
        while (s.length() == 0) {
            s = sc.nextLine();
            dem++;
            if (s.isEmpty() && dem > 1) {
                System.out.println("Wrong");
                continue;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public boolean checkValidDate(LocalDate date, String s) {
        String newString = s.substring(0, 2);//22-05-2004
        int day = date.getDayOfMonth();
        int month = date.getMonthValue();
        int year = date.getYear();
        int yearNow = LocalDate.now().getYear();
        if (day <= 0 || day > date.lengthOfMonth() || day != Integer.parseInt(newString)) {
            return false;
        }

        if (month <= 0 || month > 12) {

            return false;
        }

        if (year <= 1950 || year > yearNow) {

            return false;
        }

        return true;
    }

    public String inputName(String str) {
        String name = inputString(str).toLowerCase();
        char c = Character.toUpperCase(name.charAt(0));
        name = name.replace(name.charAt(0), c);
        return name;
    }

    public LocalDate inputDate(String str) {
        boolean check = false;
        LocalDate inputDate = LocalDate.now();
        System.out.println(str);
        do {
            try {
                String date = sc.nextLine();
                inputDate = LocalDate.parse(date, format);
                check = checkValidDate(inputDate, date);
                if (!check) {
                    System.out.println("Wrong! Please try again");
                }
            } catch (Exception ex) {
                System.out.println("Wrong! Please try again");
            }
        } while (!check);
        return inputDate;
    }

    public String inputPhone(String str) { //input string without any letter
        String number = inputString(str); 
        for (Character c : number.toCharArray()) {
            if (Character.isLetter(c) || number.length() < 10) {
                System.out.println("Wrong");
                number = inputPhone(str); 
            }
            break;
        }
        return number;
    }

    public String inputEmail(String str)
    {
        System.out.println(str);
        String email = sc.nextLine();
        int indexAtSign = email.indexOf("@");
        if(indexAtSign == -1)
        {
            System.out.println("You should have special character @ ");
            email = inputEmail(str);
        }
        int indexDot = email.indexOf(".", indexAtSign);
        if(indexDot == -1 || indexDot == indexAtSign + 1)
        {
            System.out.println("Wrong");
            email = inputEmail(str);
        }
        return email;
    }
    
    public int inputInt(String str, int min, int max)
    {
        int number;
        while(true)
        {
            System.out.println(str);
//            System.out.println("Please input number great than " + min + " and less than or equal " + max);
            try{
                number = sc.nextInt();
                if(number > min && number <= max)
                    return number;
            }
            catch (InputMismatchException e) {
                System.out.println("Only enter the integer number > 0 ");
                sc.next();
            }
        }
    }

    public int inputIntnotMax(String str, int min)
    {
        int number;
        while(true)
        {
            System.out.println(str);
            try{
                number = sc.nextInt();
//                System.out.println("Please input number great than " + min);
                if(number > min)
                    return number;
            }
            catch (InputMismatchException e) {
                System.out.println("Only enter the integer number > 0 ");
                sc.next();
            }
        }
    }

    public float inputFloatnotMax(String str, int min)
    {
        float number;
        while(true)
        {
            System.out.println(str);
            try{
                number = sc.nextFloat();
//                System.out.println("Please input number great than " + min);
                if(number > min)
                    return number;
            }
            catch (InputMismatchException e) {
                System.out.println("Only enter the integer number > 0 ");
                sc.next();
            }
        }
    }
}
