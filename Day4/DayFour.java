package Day4;

import java.util.*;
import java.io.*;

public class DayFour {
    public static void main(String[] args) {
        partOne();
        // partTwo();
    }

    static void partOne() {
        try {
            // Scanner sc = new Scanner(new File("Day4/sample.txt"));
            Scanner sc = new Scanner(new File("Day4/input.txt"));
            int count = 0;

            while(sc.hasNext()) {
                String line = sc.nextLine();
                String[] comma = line.split(",");

                Pair p1 = new Pair(Integer.parseInt(comma[0].split("-")[0]), Integer.parseInt(comma[0].split("-")[1]));
                Pair p2 = new Pair(Integer.parseInt(comma[1].split("-")[0]), Integer.parseInt(comma[1].split("-")[1]));


                if(good(p1, p2) || good(p2, p1)) {
                    count++;
                }
            }

        System.out.println(count);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    static void partTwo() {
        try {
            // Scanner sc = new Scanner(new File("Day4/sample.txt"));
            Scanner sc = new Scanner(new File("Day4/input.txt"));
            int count = 0;

            while(sc.hasNext()) {
                String line = sc.nextLine();
                String[] comma = line.split(",");

                Pair p1 = new Pair(Integer.parseInt(comma[0].split("-")[0]), Integer.parseInt(comma[0].split("-")[1]));
                Pair p2 = new Pair(Integer.parseInt(comma[1].split("-")[0]), Integer.parseInt(comma[1].split("-")[1]));


                if(inRange(p1, p2)) {
                    count++;
                }
            }

        System.out.println(count);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

      static boolean good(Pair p1, Pair p2) {
        return p1.first <= p2.first && p1.second >= p2.second;
      }

      static boolean inRange(Pair p1, Pair p2) {
        return Math.max(p1.first, p2.first) <= Math.min(p1.second, p2.second);
      }
}

class Pair implements Comparable<Pair>{
    int first, second;

    public Pair (int first, int second){
        this.first = first;
        this.second = second;
      }

      @Override
      public int compareTo(Pair p){
          if(first != p.first) return first - p.first;
          else return second - p.second;
      }

      @Override
      public String toString() {
        return "(" + this.first + "," + this.second + ")";
      }
}