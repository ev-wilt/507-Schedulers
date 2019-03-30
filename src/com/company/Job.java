package com.company;

import java.util.List;

public class Job implements Runnable {

    private Record record;
    private List<String> recordArray;

    // Constructor
    public Job(List<String> recordArray) {
        this.recordArray = recordArray;
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
