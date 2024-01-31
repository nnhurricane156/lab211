package Common;

import java.util.Scanner;

public class Validation {

    public String inputPattern(String name, String pattern) {
        Scanner sc = new Scanner(System.in);
        String s = null;
        do {
            System.out.print(String.format("Enter %s: ", name));
            s = sc.nextLine();
        } while (s == null || s.isEmpty() || !s.matches(pattern));
        return s;
    }

    public boolean checkPhone(String phone){
        String regex = "^(\\d{10}|\\(\\d{3}\\)-?\\d{3}-?\\d{4}|" +
                "\\d{3}[-\\.\\s]?\\d{3}[-\\.\\s]?\\d{4}(\\s?(x|ext)\\d{1,4})?)$";

        return phone.matches(regex);
    }
    public String normalizePhone(String phone){
        if(phone == null || phone.isEmpty()){
            return phone;
        } else {
            String normalizedPhone = phone.replaceAll("\\D","");
            return normalizedPhone.substring(0,10);
        }
    }
    public static void main(String[] args) {
        Validation validation = new Validation();
        System.out.println(validation.checkPhone("123-456-7890 ext1234"));
    }
}
