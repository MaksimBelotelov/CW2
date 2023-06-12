package org.example.controller;


import org.example.model.Toy;
import org.example.repository.ToyRepo;
import org.example.view.InputView;
import org.example.view.ToysView;

import java.util.ArrayList;

public class ToyController {
    private ToyRepo toyRepo;
    private ArrayList<Toy> toysList;

    public ToyController() {
        this.toyRepo = new ToyRepo();
        this.toysList = toyRepo.loadToysFromRepo();
    }

    public void addNewToy() {
        int id = InputView.inputIdView();
        String name = InputView.inputToyNameView();
        double weight = InputView.inputWeightView();

        if(weight > 0 && weight < 100) {
            for (var toy : toysList) {
                if (toy.getId() == id || toy.getName().equals(name)) {
                    System.out.println("Игрушка с таким Id или именем уже существует");
                    return;
                }
            }
        } else {
            System.out.println("Вес должен находиться в интервале от 0 до 100 %.");
            return;
        }
        toysList.add(new Toy(id, name, weight));
    }

    public void editWeightOfToy() {
        ToysView.showMeAllToys(toysList);
        System.out.println("Введите Id игрушки, для которой вы хотите изменить вес:");
        int idToChange = InputView.inputIdView();
        double newWeight = InputView.inputWeightView();
        for(var toy: toysList) {
            if(toy.getId() == idToChange) {
                toy.setWeight(newWeight);
                System.out.println("Вес для игрушки " + toy.getName() + " изменен на " + toy.getWeight());
                return;
            }
        }
        System.out.println("Игрушка с таким Id не найдена");
    }
}