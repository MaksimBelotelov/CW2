package org.example.view;

import org.example.controller.QueueController;
import org.example.controller.ToyController;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private String menuTitle;
    private ArrayList<MenuItem> menuItems = new ArrayList<>();
    private Scanner userInput = new Scanner(System.in);

    public Menu(String title, ToyController toyController, QueueController queueController) {
        this.menuTitle = title;

        this.menuItems.add(new MenuItem("Добавить новую игрушку") {
            @Override
            public void processItem() {
                toyController.addNewToy();
            }
        });

        this.menuItems.add(new MenuItem("Изменить вес игрушки") {
            @Override
            public void processItem() {
                toyController.editWeightOfToy();
            }
        });

        this.menuItems.add(new MenuItem("Провести розыгрыш(добавить случайную игрушку в очередь)") {
            @Override
            public void processItem() {
                String prize = toyController.giveAwayToy()
                queueController.putToyToQueue(prize);
            }
        });

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
            System.out.println("-----------------------------");
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
