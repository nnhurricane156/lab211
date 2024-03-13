package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ContactIInformation {
    private String phoneNumber;
    private String email;
    private Date date;

    public ContactIInformation(String phoneNumber, String email, Date date) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.date = date;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ContactIInformation{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", date=" + date +
                '}';
    }
}