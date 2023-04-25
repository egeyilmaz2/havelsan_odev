package org.havelsan;

import org.havelsan.hut_star_pattern.HutStarPattern;
import org.havelsan.pairs.Pairs;
import org.havelsan.turtules_path.TurtulesPath;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws Exception {
        while (true) {
            try {

                System.out.println("Please select your application (enter number 1 to 3)\n" +
                        "1-Pairs\n" +
                        "2-Hut Star pattern\n" +
                        "3-Turtle's path\n" +
                        "Enter your number: ");

                Scanner sc = new Scanner(System.in);
                int app = sc.nextInt();

                if (app == 1) {

                    System.out.println("***PAIRS***\nEnter the length: ");

                    int actualLength = sc.nextInt();
                    int intArray[] = new int[actualLength];

                    System.out.println("Enter the elements of the array: ");
                    for (int i = 0; i < actualLength; i += 1) {
                        intArray[i] = sc.nextInt();
                    }
                    int output = Pairs.run(actualLength, intArray);
                    System.out.println("Answer is: " + output);
                }


                if (app == 2) {
                    System.out.println("***Hut_Star_Pattern***\nEnter the n: ");

                    int nLength = sc.nextInt();

                    if(nLength<5){
                        throw new Exception("nLength should be bigger than 5");
                    }else{
                        HutStarPattern.run(nLength);
                    }
                }

                if (app == 3) {
                    System.out.println("***Turtules_Path***\nplease paste txt file location(enter 0 for sample): ");
                    sc.nextLine();

                    String file = sc.nextLine();
                    if(file.equals("0")){
                        file = "src/main/java/org/havelsan/turtules_path/sample_path.txt";
                    }

                    BufferedReader reader;
                    List<int[]> inputs=new ArrayList<>();

                    try {
                        reader = new BufferedReader(new FileReader(file));
                        String line = reader.readLine();

                        while (line != null) {

                            int[] lineArray = Stream.of(line.split(" "))
                                    .mapToInt(token -> Integer.parseInt(token))
                                    .toArray();
                            inputs.add(lineArray);
                            line = reader.readLine();
                        }

                        reader.close();

                        TurtulesPath turtulesPath = new TurtulesPath(inputs.size(),inputs.get(0).length,inputs);

                        System.out.println(turtulesPath.getValidPaths());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                System.err.println("Something went wrong. Please be sure about to entering valid input");
                System.out.println("Error detail: " + e.getMessage());
            }

        }

    }
}