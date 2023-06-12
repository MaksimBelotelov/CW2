package org.example.repository;

import org.example.model.Toy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class ToyRepo {
    public static final String TOYSPATH = "ToysData.txt";

    public ArrayList<Toy> loadToysFromRepo() {
        ArrayList<Toy> toys = new ArrayList<>();

        try {
            File file = new File(TOYSPATH);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String id = reader.readLine();
            while (id != null) {
                String name = reader.readLine();
                double weight = Double.valueOf(reader.readLine());
                toys.add(new Toy(Integer.valueOf(id), name, weight));
                id = reader.readLine();
            }
            reader.close();
            fr.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return toys;
    }
}
