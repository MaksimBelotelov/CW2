package org.example.repository;

import org.example.model.Toy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.PriorityQueue;

public class QueueRepo {
    public static final String QUEUEPATH = "QueueData.txt";


    public PriorityQueue<String> loadQueueFromRepo() {
        PriorityQueue<String> queueOfPrizes = new PriorityQueue<String>();
        try {
            File file = new File(QUEUEPATH);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String name = reader.readLine();
            while (name != null) {
                queueOfPrizes.add(new String(name));
                name = reader.readLine();
            }
            reader.close();
            fr.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return queueOfPrizes;
    }
}
