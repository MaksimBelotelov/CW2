package org.example.repository;

import java.io.FileWriter;
import java.util.PriorityQueue;

public class GivenOutRepo {
    public static final String GIVENOUTPATH = "GivenOutToys.txt";

    public void saveGivenOutToRepo(String toy) {
        try (FileWriter writer = new FileWriter(GIVENOUTPATH,true)){
            writer.write(toy + "\n");
            writer.flush();
            writer.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}