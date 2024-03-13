package View;

import Common.Inputter;
import Model.ContactIInformation;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ValidateProgramView {
    ArrayList<ContactIInformation> arrayList = new ArrayList<>();
    Inputter inputter = new Inputter();
    public void addContact(){
        arrayList.add(new ContactIInformation(inputter.getPhone(),inputter.getEmail(),inputter.getDate()));
    }

    public void showData(){
        arrayList.forEach(contactIInformation -> System.out.println(contactIInformation.toString()));
    }
}
