package Controller;

import View.ContactView;
import View.Menu;

public class ContactManager extends Menu {
    ContactView contactView = new ContactView();

    public ContactManager() {
        super("ContactManagement", new String[]{
                "Add a contact",
                "Display all contacts",
                "Delete a contact",
                "Exit"
        });
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                contactView.addContact();
                break;
            case 2:
                contactView.display();
                break;
            case 3:
                contactView.deleteContact();
                break;
            default:
                System.out.println("Thank You !!!");
                break;
        }
    }
}
