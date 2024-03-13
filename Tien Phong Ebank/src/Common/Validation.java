package Common;

public class Validation {
    public boolean checkAccountNumber(String accountNumber) {
        return accountNumber.matches("\\d{10}") && accountNumber.matches("\\d+");
    }

    public boolean checkPassword(String password) {
        return password.matches("[a-zA-Z0-9]{8,31}");
    }
}
