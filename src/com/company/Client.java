package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Client {
    private List<List<String>> input = new ArrayList<>();

    public Client() {
        Scanner inputStream;

        try{
            File file= new File("FloridaCounties.csv");
            inputStream = new Scanner(file);

            while(inputStream.hasNextLine()){
                String line= inputStream.nextLine();
                String[] values = line.split(",");
                input.add(Arrays.asList(values));
            }

            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public List<List<String>> getInput() {
        return input;
    }
}
