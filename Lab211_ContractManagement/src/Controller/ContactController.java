package Controller;

import Model.Contact;
import View.ContactView;
import View.Menu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContactController extends Menu {
    private static Map<Integer, Contact> contacts = new HashMap<>();
    Scanner scanner = new Scanner(System.in);
    ContactView view = new ContactView();

    public ContactController(){
        super("Contact Management", new String[]{"Input Contact", "View All Contact", "Delete Contact", "Exit"});
    }

    @Override
    public void execute(int choice) {
        switch (choice){
            case 1:
                view.addContact(contacts);
                break;
            case 2:
                view.viewAllContacts(contacts);
                break;
            case 3:
                view.deleteContract(contacts);
                break;
            case 4:
                System.exit(0);
        }
    }
}
