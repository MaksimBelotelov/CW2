package org.example;

import org.example.controller.QueueController;
import org.example.controller.ToyController;
import org.example.view.Menu;

import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Menu mainMenu = new Menu("Главное меню: ", new ToyController(), new QueueController());
        mainMenu.startMenu();
    }
}