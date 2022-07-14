package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)  {
        String path = "C:\\Users\\Kirill\\IdeaProjects\\TestAufgabeMaven\\src\\main\\resources\\input.txt";
        ArrayList<Linie> linien = getLinesFromFile(path);

    }

    public static ArrayList<Linie> getLinesFromFile(String path){
        ArrayList<Linie> linien = new ArrayList<>();

        File file = new File(path);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                double[] numbers = Arrays.stream(line.split(" "))
                        .mapToDouble(Double::parseDouble).toArray();

                Point p1 = new Point(numbers[0], numbers[1]);
                Point p2 = new Point(numbers[2], numbers[3]);

                Linie linie = new Linie(p1, p2);
                linien.add(linie);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return linien;
    }
}