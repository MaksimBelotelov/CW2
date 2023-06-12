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

    public String giveAwayToy() {
        int sumOfWeights = 0;
        int rand = (int)(Math.random()*100);
        int prevChanceBorder = 0;
        for(var toy: toysList)
            sumOfWeights += toy.getWeight();
        for(int i = 0; i < toysList.size(); i++) {
            int chance = (int)((toysList.get(i).getWeight()/sumOfWeights)*100);
            if(rand > prevChanceBorder && rand <= prevChanceBorder + chance) {
                return toysList.get(i).getName();
            }
            prevChanceBorder += chance;
        }
        return null;
    }
}