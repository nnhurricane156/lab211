package Common;


public class Validation {

    public boolean isValid(String data, String regex) {
        if (!data.trim().matches(regex)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isName(String data) {
        if (data.isEmpty())
            return false;
        return true;
    }

    public boolean isPrice(String data) {
        try {
            Double.parseDouble(data);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isQuantity(String data) {
        try {
            Long.parseLong(data);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isOrigin(String data) {
        if (!data.isEmpty()) {
            return true;
        }
        return false;
    }

    public Double getPrice(String data){
        try {
            isPrice(data);
            return Double.parseDouble(data);
        }catch (NumberFormatException e){
            e.printStackTrace();
            return null;
        }
    }

    public Long getQuantity(String data){
        try{
            isQuantity(data);
            return Long.parseLong(data);
        } catch (NumberFormatException e){
            e.printStackTrace();
            return null;
        }
    }
}
