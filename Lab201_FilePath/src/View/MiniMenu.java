/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ntkhai
 */
public class MiniMenu {

    protected String title;
    protected ArrayList<String> list = new ArrayList();

    public MiniMenu(){}
    public MiniMenu(String title, String[] s) {
        this.title = title;
        for (String item : s) {
            list.add(item);
        }
        display();
    }

    public void display() {
        System.out.println(title);
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    public int getChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter selection: ");
        int choice = scanner.nextInt();
        return choice;
    }

    public void execute(int choice)
    {
    }

    public void run() {
        int choice;
        do {
            display();//list the content of menu
            choice = getChoice();
            execute(choice);
            System.out.println("");
        } while (choice > 0 && choice < list.size()-1);

    }
}
