package View;

import Common.Inputter;
import Controller.ContactManager;
import Model.Contact;

import java.io.*;
import java.util.ArrayList;

public class ContactView {
    public ContactView() {
        loadData("src/input.txt");
    }

    Inputter inputter = new Inputter();
    private ArrayList<Contact> contactsList = new ArrayList<>();
    public void loadData(String path){
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length == 7) {
                    String fullName = data[1].trim();
                    String group = data[4].trim();
                    String address = data[5].trim();
                    String phone  = data[6].trim();
                    contactsList.add(new Contact(fullName,group,address,phone));
                    }
                }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void display(){
        contactsList.forEach(contact -> {
            System.out.println(contact.toString());
        });
    }

    public void addContact(){
        System.out.println("--------Add a Contact--------");
        String name = inputter.getString("Name");
        String group = inputter.getString("Group");
        String address = inputter.getString("Address");
        String phone = inputter.getPhone();

        contactsList.add(new Contact(name,group,address,phone));
        updateData("src/input.txt");
        System.out.println("Successful !!!");
    }

    public void updateData(String path) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (Contact contact : contactsList) {
                String line = buildDataLine(contact);
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private String buildDataLine(Contact contact) {
        return String.format("%s|%s|%s|%s|%s|%s|%s",
                contact.getId(),
                contact.getFullName(),
                contact.getFirstName(),
                contact.getLastName(),
                contact.getGroup(),
                contact.getAddress(),
                contact.getPhone());
    }
    public void deleteContact(){
        int id = inputter.getId("ID");
        for(Contact contact : contactsList){
            if(contact.getId() == id){
                contactsList.remove(contact);
                break;
            }
        }
    }
}
