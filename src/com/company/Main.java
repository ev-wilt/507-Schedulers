package com.company;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Client test = new Client();
        List<List<String>> input = test.getInput();
        System.out.println(input.get(1));

    }
}
