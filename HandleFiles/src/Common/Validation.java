package Common;

public class Validation {
    public boolean isString(String data){
        return !data.isEmpty();
    }

    public double isDouble(String data){
        try{
            return Double.parseDouble(data);
        } catch (Exception e){
            System.out.println("Wrong format !!!");
            return 0;
        }
    }
}
