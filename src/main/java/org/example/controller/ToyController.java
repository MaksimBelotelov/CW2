package org.example.controller;


import org.example.model.Toy;
import org.example.repository.ToyRepo;

import java.util.ArrayList;

public class ToyController {
    private ToyRepo toyRepo;
    private ArrayList<Toy> toysList;

    public ToyController() {
        this.toyRepo = new ToyRepo();
        this.toysList = toyRepo.loadToysFromRepo();
    }
}
