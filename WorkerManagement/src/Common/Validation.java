package Common;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Validation {
    public boolean isValid(String data, String regex) {
        return data.matches(regex);
    }

    public boolean isString(String data){
        return !data.isEmpty();
    }

    public boolean isSuited(String data){
        LocalDate today = LocalDate.now();
        int age = today.getYear() - Integer.parseInt(data);
        return age >= 18 && age <= 50;
    }

}
