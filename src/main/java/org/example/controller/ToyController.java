package org.example.controller;


import org.example.model.Toy;
import org.example.repository.ToyRepo;
import org.example.view.InputView;

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
        for(var toy: toysList) {
            if(toy.getId() == id || toy.getName().equals(name)) {
                System.out.println("Игрушка с таким Id или именем уже существует");
                return;
            }
        }
        toysList.add(new Toy(id, name, InputView.inputWeightView()));
    }
}