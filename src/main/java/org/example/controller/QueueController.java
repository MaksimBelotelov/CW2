package org.example.controller;

import org.example.repository.QueueRepo;

import java.util.PriorityQueue;

public class QueueController {
    private QueueRepo queueRepo;
    private PriorityQueue<String> priorityQueue;


    public QueueController() {
        this.queueRepo = new QueueRepo();
        this.priorityQueue = queueRepo.loadQueueFromRepo();
    }

    public void putToyToQueue(String name) {
        priorityQueue.add(name);
        queueRepo.saveQueueToRepo(priorityQueue);
    }
}
