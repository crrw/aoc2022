package Day2;

import java.util.*;
import java.io.*;


public class DayTwo {

        /*
         * rock rock -> AX -> 3
         * rock paper -> AY -> 6
         * rock sicssor -> AZ -> 0
         * 
         * paper rock -> BX -> 0
         * paper paper -> BY -> 3
         * paper sicssor -> BZ -> 6
         * 
         * sicssor rock -> CX -> 6
         * scissor paper -> CY -> 0
         * scissor scissor -> CZ -> 3
         */
        static Map<String, Integer> scores = Map.of(
                "AX", 3,
                "AY", 6,
                "AZ", 0,
                "BX", 0,
                "BY", 3,
                "BZ", 6,
                "CX", 6,
                "CY", 0,
                "CZ", 3);


        static Map<String, Integer> pieceScore = Map.of("X", 1, "Y", 2, "Z", 3);

    public static void main(String[] args) {
        //partOne();
        partTwo();
    }

    static void partOne() {

        try {
            // Scanner sc = new Scanner(new File("Day2/sample.txt"));
            Scanner sc = new Scanner(new File("Day2/input.txt"));

            int count = 0;
            while (sc.hasNext()) {
                String[] line = sc.nextLine().split("\\s");
                String first = line[0], second = line[1];
                count += scores.get(first + second);
                count += pieceScore.get(second);
            }
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void partTwo() {
        try {
            //Scanner sc = new Scanner(new File("Day2/sample.txt"));
            Scanner sc = new Scanner(new File("Day2/input.txt"));

            Map<String, String> draw = Map.of("A", "X", "B", "Y", "C", "Z");
            Map<String, String> win = Map.of("A", "Y", "B", "Z", "C", "X");
            Map<String, String> lose = Map.of("A", "Z", "B", "X", "C", "Y");

            int count = 0;
            while (sc.hasNext()) {
                String[] line = sc.nextLine().split("\\s");
                String first = line[0], second = line[1];

                if(second.equals("X")) {
                    count += 0;
                    String curr = lose.get(first);
                    count += pieceScore.get(curr);
                } 
                else if(second.equals("Y")) {
                    count += 3;
                    String curr = draw.get(first);
                    count += pieceScore.get(curr);
                }
                else {
                    count += 6;
                    String curr = win.get(first);
                    count += pieceScore.get(curr);
                }
            }

            System.out.println(count);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}