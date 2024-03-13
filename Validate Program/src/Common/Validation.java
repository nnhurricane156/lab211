package Common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validation {
    public int checkPhone(String phone) {
        if (phone.matches("\\d*")) {
            if (phone.length() == 10) {
                return 0;
            } else {
                return 1;
            }
        } else
            return 2;
    }

    public boolean checkEmail(String email) {
        String regex = "\\w{5,}@\\w{3,}.com";
        if (email.matches(regex))
            return true;
        else
            return false;
    }

}
