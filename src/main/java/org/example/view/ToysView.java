package org.example.view;

import org.example.model.Toy;

import java.util.ArrayList;

public class ToysView {

    public static void showMeAllToys(ArrayList<Toy> toysList) {
        System.out.println("ID  Name              Weight");
        System.out.println("-----------------------------");
        for(var toy: toysList)
            System.out.println(toy);
    }

    public static void addedToQueueMessage(String name) {
        System.out.println("Розыгрыш проведен!");
        System.out.println("В очередь для выдачи добавлена игрушка: " + name);
        System.out.println("-----------------------------");
    }

    public static void addedToListOfToys(String name) {
        System.out.println("Игрушка " + name + "добавлена в список для розыгрыша");
        System.out.println("-----------------------------");
    }
}
