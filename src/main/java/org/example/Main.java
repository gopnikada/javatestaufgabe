package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args)  {
        String path = "C:\\Users\\Kirill\\IdeaProjects\\TestAufgabeMaven\\src\\main\\resources\\inputTest.txt";
        ArrayList<Linie> linien = getLinesFromFile(path);

        ArrayList<Linienzug> linienZuege = converLinienToLinienzuege(linien);

    }

    private static ArrayList<Linienzug> converLinienToLinienzuege(ArrayList<Linie> linien) {
        ArrayList<Linienzug> linienZuege = new ArrayList<>();

        linienZuege.add(new Linienzug());
        var lastZug = linienZuege.get(linienZuege.size()-1);

        for(Linie currentLine:linien){

            lastZug.addLine(currentLine);

            var foundNeighbors = linien.stream().filter(x->
                            !x.equals(currentLine)
                                    &&
                                    (
                                    currentLine.getStartPoint().equals(x.getStartPoint())
                                    ||currentLine.getStartPoint().equals(x.getEndPoint())
                                    ||currentLine.getEndPoint().equals(x.getStartPoint())
                                    ||currentLine.getEndPoint().equals(x.getEndPoint())
                            )
                    ).toList();
            if(foundNeighbors.size()==0){
                continue;
            }
            else if(foundNeighbors.size()<3){
                lastZug.addLine(foundNeighbors.get(0));
            }else{
                Linienzug lz = new Linienzug(currentLine);
                linienZuege.add(lz);
            }
        }
        linienZuege.stream().forEach(x->x.getLinien().stream().distinct().toList());


        return linienZuege;
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