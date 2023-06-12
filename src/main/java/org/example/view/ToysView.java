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
}
