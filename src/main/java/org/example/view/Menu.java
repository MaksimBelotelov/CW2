package org.example.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private String menuTitle;
    private ArrayList<MenuItem> menuItems = new ArrayList<>();
    private Scanner userInput = new Scanner(System.in);

    public Menu(String title) {
        this.menuTitle = title;

        this.menuItems.add(new MenuItem("Выход") {
            @Override
            public void processItem() {
                System.out.println("До свидания!");
                System.exit(0);
            }
        });
    }

    public void startMenu() {
        int choice = 0;
        System.out.println(menuTitle);
        while(true) {
            for(int i = 0; i < menuItems.size(); i++)
                System.out.println(i + ". " + menuItems.get(i).getItemName());
            if (userInput.hasNextInt()){
                choice = userInput.nextInt();
                if(choice < menuItems.size() && choice >= 0)
                    menuItems.get(choice).processItem();
                else
                    System.out.println("Необходимо вести цифру от 0 до " + (menuItems.size()-1) + "\n");
            }
            else {
                System.out.println("Необходимо ввести цифру");
                userInput.next();
            }
        }
    }
}
