package Library;

import java.time.LocalDate;

public class Validation {
    public boolean isEmpty(String check)
    {
        if(check.isEmpty())
            return true;
        return false;
    }

    public boolean isNumeric(String check)
    {
        if(isEmpty(check))
        {
            System.out.println("Please input something");
            return false;
        }
        try{
            Double.parseDouble(check);
            return true;
        }catch(NumberFormatException ex)
        {
            System.out.println("Not Valid");
            return false;
        }
    }

    public boolean isValidName(String check)
    {
        for(Character c : check.toCharArray())
        {
            if(!Character.isLetter(c) && c != ' ')
                return false;
        }
        return true;
    }

    public boolean isValidPhone(String check)
    {
        for(Character c : check.toCharArray())
        {
            if(!Character.isDigit(c))
                return false;
        }
        return true;
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
}


