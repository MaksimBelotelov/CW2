package org.example.controller;

import org.example.repository.GivenOutRepo;
import org.example.repository.QueueRepo;

import java.util.PriorityQueue;

public class QueueController {
    private QueueRepo queueRepo;
    private PriorityQueue<String> priorityQueue;
    private GivenOutRepo givenOutRepo;



    public QueueController() {
        this.queueRepo = new QueueRepo();
        this.priorityQueue = queueRepo.loadQueueFromRepo();
        this.givenOutRepo = new GivenOutRepo();
    }

    public void putToyToQueue(String name) {
        priorityQueue.add(name);
        queueRepo.saveQueueToRepo(priorityQueue);
    }

    public String popToyFromQueue() {
        String toyToGive = priorityQueue.poll();
        if(!(toyToGive == null)) {
            queueRepo.saveQueueToRepo(priorityQueue);
            givenOutRepo.saveGivenOutToRepo(toyToGive);
        }
        return toyToGive;
    }
}
