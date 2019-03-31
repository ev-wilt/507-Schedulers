package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Scheduler {

    private ExecutorService threadPool;
    private final int THREAD_COUNT = 10;
    private static ConcurrentHashMap<String, ArrayList<String>> houseTypes;

    // Constructor
    public Scheduler() {
        this.threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
        this.houseTypes = new ConcurrentHashMap<>();
    }

    // Adds a new job to the thread pool
    public void addJob(List<String> recordArray) {
        Job newJob = new Job(recordArray, houseTypes);
        threadPool.execute(newJob);
    }

    // Shuts down the thread pool
    public void shutDown() {
        this.threadPool.shutdown();
    }
}
