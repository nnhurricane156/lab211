package Common;

import java.util.Scanner;

public class Inputter {
    Validation validation = new Validation();
    Scanner scanner = new Scanner(System.in);
    public String getString(String name) {
        String s = null;
        while (s == null || s.isEmpty()) {
            System.out.printf("Enter %s: ", name);
            s = scanner.nextLine();
        }
        return s;
    }

    public String getPhone(){
        String s = null;
        while (s == null || s.isEmpty() ){
            System.out.print("Please input Phone flow\n" +
                    "• 1234567890\n" +
                    "• 123-456-7890 \n" +
                    "• 123-456-7890 x1234\n" +
                    "• 123-456-7890 ext1234\n" +
                    "• (123)-456-7890\n" +
                    "• 123.456.7890\n" +
                    "• 123 456 7890\n");
            System.out.print("Enter Phone: ");
            s= scanner.nextLine();
            if(validation.checkPhone(s)){
                s = validation.normalizePhone(s);
            }
        }
        return s;
    }

    public int getId(String name){
        String num = null;
        while (true){
            System.out.printf("Enter %s: ",name);
            try{
                num = scanner.nextLine();
                return Integer.parseInt(num);
            } catch (NumberFormatException e){
                System.out.println("Wrong Format !!!");
            }
        }
    }
}
