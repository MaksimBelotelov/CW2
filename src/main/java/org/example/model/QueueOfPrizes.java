package org.example.model;

import java.util.PriorityQueue;

public class QueueOfPrizes {
    private PriorityQueue<String> queueOfPrizes;

    public QueueOfPrizes() {
    }

    public PriorityQueue<String> getQueueOfPrizes() {
        return queueOfPrizes;
    }

    public void setQueueOfPrizes(PriorityQueue<String> queueOfPrizes) {
        this.queueOfPrizes = queueOfPrizes;
    }
}


