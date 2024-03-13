package View;

import Common.Inputter;
import Common.Validation;
import Model.En;
import Model.Student;
import Model.Vi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class EbankView {
    Inputter inputter = new Inputter();
    private ArrayList<Student> studentArrayList;
    Validation validation = new Validation();

    public EbankView(){
        studentArrayList = new ArrayList<>();
        loadData("src/data.txt");
    }

    public void loadData(String path){
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length == 2) {
                    String accountNumber = data[0].trim();
                    String password = data[1].trim();
                    if(validation.checkAccountNumber(accountNumber) && validation.checkPassword(password) ){
                        studentArrayList.add(new Student(accountNumber,password));
                    }
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void resourceBundle(Object language){
        if(language instanceof En){
            En en =  (En) language;
            String accountNumber = inputter.getAccountNumber(en.getAccount(),en.getAccountError());
            String password = inputter.getPassword(en.getPassword(),en.getPasswordError());

            System.out.println(accountNumber);

            System.out.println(password);
        } else {
            Vi vi =  (Vi) language;
            String accountNumber = inputter.getAccountNumber(vi.getAccount(),vi.getAccountError());
            String password = inputter.getPassword(vi.getPassword(),vi.getPasswordError());

            System.out.println(accountNumber);
            System.out.println(password);
        }
    }


}
