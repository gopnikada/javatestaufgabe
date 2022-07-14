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


//       for (int i = 0; i<linien.size();i++){
//           //init
//           Linienzug linienZug = new Linienzug();
//           linienZug.addLine(linien.get(i));
//
//           for (int j = 0; j<linien.size();j++){
//               //pass this
//                if(linien.get(i).equals(linien.get(j))){
//                    continue;
//                }
//
//                if(
//                        linien.get(i).getStartPoint().equals(linien.get(j).getStartPoint())
//                        ||linien.get(i).getStartPoint().equals(linien.get(j).getEndPoint())
//                        ||linien.get(i).getEndPoint().equals(linien.get(j).getStartPoint())
//                        ||linien.get(i).getEndPoint().equals(linien.get(j).getEndPoint())
//                ){
//                    linienZug.addLine(linien.get(j));
//                    break;
//                }
//
//           }
//       }

        for (Linie mainLine:linien){
            Linienzug linienZug = new Linienzug();
            linienZug.addLine(mainLine);

            linien.removeAll(linienZug.getLinien());
            for (Linie lineToAdd:linien){
                if(mainLine.equals(lineToAdd)){
                    continue;
                }

                if(
                        mainLine.getStartPoint().equals(lineToAdd.getStartPoint())
                        ||mainLine.getStartPoint().equals(lineToAdd.getEndPoint())
                        ||mainLine.getEndPoint().equals(lineToAdd.getStartPoint())
                        ||mainLine.getEndPoint().equals(lineToAdd.getEndPoint())
                ){
                    linienZug.addLine(lineToAdd);
                }
            }
        }


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