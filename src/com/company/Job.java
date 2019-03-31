package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Job implements Runnable {

    private Record record;
    private List<String> recordArray;
    private static ConcurrentHashMap<String, ArrayList<String>> houseTypes;

    // Constructor
    public Job(List<String> recordArray, ConcurrentHashMap<String, ArrayList<String>> houseTypes) {
        this.recordArray = recordArray;
        this.houseTypes = houseTypes;
    }

    public void TaskOne() {
        this.record = new Record(this.recordArray);
    }

    public void TaskTwo() {
        for (int i = 0; i < this.record.getEqSiteLimit(); ++i) {}
        for (int i = 0; i < this.record.getFlSiteLimit(); ++i) {}
        for (int i = 0; i < this.record.getHuSiteLimit(); ++i) {}
        for (int i = 0; i < this.record.getFlSiteLimit(); ++i) {}
    }

    public void TaskThree() {
        double distance = Math.sqrt(Math.pow(30 - this.record.getPointLatitude(), 2) + Math.pow(-81 - this.record.getPointLongitude(), 2));
        System.out.println("Distance: " + distance);
    }

    public void TaskFour() {

        // Check if hash map already contains the line key
        if (this.houseTypes.containsKey(this.record.getLine())) {

            // Add the construction if not already in the list
            if (!this.houseTypes.get(this.record.getLine()).contains(this.record.getConstruction())) {
                this.houseTypes.get(this.record.getLine()).add(this.record.getConstruction());
            }
        }

        // Add a new key and list otherwise
        else {
            ArrayList<String> newConstruction = new ArrayList<>();
            newConstruction.add(this.record.getConstruction());
            this.houseTypes.put(this.record.getLine(), newConstruction);
        }

        int houseTypeCount = 0;
        for (ArrayList<String> currentList : this.houseTypes.values()) {
            houseTypeCount += currentList.size();
        }
        System.out.println(houseTypeCount);
    }

    public void TaskFive() {
        if (this.record.getEqSiteLimit() >= 800000) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void run() {

        // Always do task 1 first
        TaskOne();

        String pointGranularity = this.recordArray.get(17);
        switch (pointGranularity) {
            case "1":
                TaskTwo();
                TaskThree();
                TaskFour();
                TaskFive();
                break;

            case "2":
                TaskThree();
                TaskFour();
                TaskFive();
                TaskTwo();
                break;

            case "3":
                TaskFive();
                TaskFour();
                TaskThree();
                TaskTwo();
                break;

            case "4":
                TaskFour();
                TaskTwo();
                TaskFive();
                TaskThree();
                break;

            case "5":
                TaskTwo();
                TaskFive();
                TaskThree();
                TaskFour();
                break;

            case "7":
                TaskThree();
                TaskTwo();
                TaskFive();
                TaskFour();
                break;

            default:
                break;
        }
    }
}
