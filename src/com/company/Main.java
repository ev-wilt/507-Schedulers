package com.company;

        import java.util.List;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        Scheduler scheduler = new Scheduler();

        List<List<String>> input = client.getInput();
        for (int i = 1; i < input.size(); ++i) {

            // Pass string to scheduler for processing
            scheduler.addJob(input.get(i));

            // Sleep for WAIT seconds
            long waitSeconds = Long.parseLong(input.get(i).get(0));
            try {
                Thread.sleep(waitSeconds * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        scheduler.shutDown();
    }
}
