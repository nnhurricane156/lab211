package Library;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Input {
    Validation validation = new Validation();
    Scanner scanner = new Scanner(System.in);
    Process process = new Process();
    SimpleDateFormat dateFormat = new SimpleDateFormat();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     *
     * @param str
     * @param canbeEmpty canBeEmpty Whether the string can be empty
     *                              - true: allow empty string
     *                              - false: not allow empty string
     * @return The input String
     */
    public String inputString(String str, boolean canbeEmpty)
    {
        while(true)
        {
            System.out.println(str);
            String s = scanner.nextLine();
            if(canbeEmpty)
                return s;
            else
            {
                if(!validation.isEmpty(s))
                    return s;
                System.out.println("Please input something");
            }
        }
    }

    /**
     *
     * @param str The prompt message
     * @param type The Number type expected (Integer, Long, Float, Double)
     * @return The input number in Object form
     *
     */
    public Object inputNumber(String str,  Class<? extends Number> type)
    {
        while(true)
        {
            System.out.println(str);
            String number = scanner.nextLine();
            if(validation.isNumeric(number))
            {
                try{
                switch (type.getSimpleName().toLowerCase())
                {

                        case "integer":
                            return Integer.parseInt(number);
                        case "long":
                            return Long.parseLong(number);
                        case "float":
                            return Float.parseFloat(number);
                        case "double":
                            return Double.parseDouble(number);
                }
                }catch (NumberFormatException exception)
                {
                    System.out.println("Please enter an integer");
                    continue;
                }
            }
        }
    }

    public String inputName(String str)
    {
        while(true)
        {
            String name = inputString(str,false);
            if(!validation.isValidName(name))
                System.out.println("Not Valid");
            else
                return process.normalizeName(name);
        }
    }

    public String inputNumbertoString(String str, boolean canbeEmpty, int quantity)
    {
        while (true)
        {
            String phoneNumber = inputString(str,canbeEmpty);
            if(canbeEmpty && phoneNumber.isEmpty())
                return phoneNumber;
            if((phoneNumber.length() != quantity) || !validation.isValidPhone(phoneNumber))
                continue;
            return phoneNumber;
        }
    }
    public LocalDate inputDate(String str) {
        boolean check = false;
        LocalDate inputDate = LocalDate.now();
        System.out.println(str);
        do {
            try {
                String date = scanner.nextLine();
                inputDate = LocalDate.parse(date, format);
                check = validation.checkValidDate(inputDate, date);
                if (!check) {
                    System.out.println("Wrong! Please try again");
                }
            } catch (Exception ex) {
                System.out.println("Wrong! Please try again");
            }
        } while (!check);
        return inputDate;
    }

    public String inputEmail(String str)
    {
        System.out.println(str);
        String email = scanner.nextLine();
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
        while(true)
        {
            int number = (Integer)inputNumber(str,Integer.class);
            if(number <= min || number >= max)
            {
                System.out.println("Please input number greater than " + min + " and less than " + max );
                continue;
            }
            return number;
        }
    }

    public int inputIntNotMax(String str, int min)
    {
        while(true)
        {
            int number = (Integer)inputNumber(str,Integer.class);
            if(number <= min)
            {
                System.out.println("Please input number greater than " + min);
                continue;
            }
            return number;
        }
    }

    public int inputIntNotMin(String str, int min, int max)
    {
        while(true)
        {
            int number = (Integer)inputNumber(str,Integer.class);
            if(number >= max)
            {
                System.out.println("Please input number less than " + max );
                continue;
            }
            return number;
        }
    }

    public static void main(String[] args) {
        Input i = new Input();
        System.out.println(i.inputInt("",0,10));
    }
}
