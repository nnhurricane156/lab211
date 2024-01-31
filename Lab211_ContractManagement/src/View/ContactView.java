package View;

import Common.Input;
import Model.Contact;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

public class ContactView {
    Input input = new Input();

    public void addContact(Map<Integer, Contact> contacts){
        String firstName = input.inputString("Enter first name: ");
        String lastName = input.inputString("Enter last name: ");
        String group = input.inputString("Enter group: ");
        String address = input.inputString("Enter address: ");
        String phone = input.inputPhone("Enter phone: ");

        Contact newContact = new Contact(firstName, lastName, group, address, phone);
        contacts.put(newContact.getID(), newContact);

        System.out.println("Contact added successfully!");
        System.out.println(newContact.getFirstName());
        System.out.println(newContact.getLastName());
        System.out.println(newContact.toString());
    }

    public void viewAllContacts(Map<Integer, Contact> contacts) {
        System.out.println("All Contacts:");
        for (Contact contact : contacts.values()) {
            System.out.println(contact.toString());
        }
    }

    public void deleteContract(Map<Integer, Contact> contacts){
        int contactID = input.inputIntnotMax("Enter contact id to delete: ", 0);
        if (contacts.containsKey(contactID)){
            Contact deletedContact = contacts.remove(contactID);
            System.out.println("Deleted contact id " + contactID);
            viewAllContacts(contacts);
        }else{
            System.out.println("ID not existed");
        }
    }
}
