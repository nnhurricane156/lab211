package View;

import Common.Validation;
import Model.People;

import java.io.*;
import java.util.ArrayList;

public class HandleFilesView {
    Validation validation = new Validation();
    ArrayList<People> peopleList;

    public HandleFilesView() {
        peopleList = new ArrayList<>();
    }

    public ArrayList<People> loadData(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(";");
                if (arr.length == 3) {
                    boolean isName = validation.isString(arr[0].trim()),
                            isAddress = validation.isString(arr[1].trim());
                    double salary = validation.isDouble(arr[2].trim());

                    if (isName && isAddress) {
                        peopleList.add(new People(arr[0].trim(), arr[1].trim(), salary));
                    }
                }
            }
            return peopleList;
        } catch (IOException e) {
            System.out.println("File does not exist !!!");
            e.printStackTrace();
            return null;
        }
    }

    public void writeData(String fileName) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            System.out.println("People size" + peopleList.size());
            for (People people : peopleList) {
                bw.write(people.getName() + ";" +
                        people.getAddress() + ";" +
                        people.getSalary());
                bw.newLine();
            }
            bw.write("phong");
            bw.newLine();

            bw.close();
            System.out.println("Copy done...");
        } catch (IOException e) {
            System.out.println("Sth wrong !!!");
            e.printStackTrace();
        }
    }

    public void getPerson(double money) {
        double max = peopleList.get(0).getSalary();
        String nameMax = peopleList.get(0).getName();

        double min = peopleList.get(0).getSalary();
        String nameMin = peopleList.get(0).getName();

        for (int i = 0; i < peopleList.size(); i++) {
            if (peopleList.get(i).getSalary() >= money) {
                System.out.println(peopleList.get(i));

                if (peopleList.get(i).getSalary() > max) {
                    max = peopleList.get(i).getSalary();
                    nameMax = peopleList.get(i).getName();
                } else if (peopleList.get(i).getSalary() < min) {
                    min = peopleList.get(i).getSalary();
                    nameMin = peopleList.get(i).getName();
                }
            }
        }
        System.out.println("Max :" + nameMax);
        System.out.println("Min :" +  nameMin);
    }

    public void clear(){
        peopleList.clear();
    }
}
