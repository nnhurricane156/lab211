package Controller;

import Model.En;
import Model.Vi;
import View.Menu;

public class EbankController extends Menu {
    public EbankController() {
        super("-------Login Program-------", new String[]{"Vietnamese", "English", "Exit"});
    }

    En en = new En("Account number","Account number must is a number and must have 10 digits",
            "Password ","Password must be between 8 and 31 characters and must be alphanumeric",
            "Enter a Captcha Code","Incorrect Captcha");

    Vi vi = new Vi("So tai khoan","So tai khoan phai la 1 so va phai co 10 chu so",
            "Mat khau","Mat khau phai trong khoang 8-31 ky tu va phai chua ky tu va so",
            "Nhap 1 ky tu captcha","Captcha sai");

    @Override
    public void execute(int choice) {
        switch (choice) {

        }
    }
}
