/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Library.Input;

import java.util.ArrayList;

/**
 *
 * @author ntkhai
 */
public abstract class Menu {

    protected String title;
    protected ArrayList<String> list = new ArrayList();
    Input input = new Input();
    public Menu(){}
    public Menu(String title, String[] s) {
        this.title = title;
        for (String item : s) {
            list.add(item);
        }
    }

    public void display() {

        System.out.println(title);
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    public int getChoice() {
        int choice = (Integer) input.inputNumber("Enter selection: ", Integer.class);
        return choice;
    }

    public abstract void execute(int choice);

    public void run() {
        int choice;
        do {
            display();//list the content of menu
            choice = getChoice();
            execute(choice);
            System.out.println("");
        } while (choice > 0 && choice < list.size());

    }
}
