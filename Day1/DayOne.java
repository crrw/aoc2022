package Day1;

import java.util.*;
import java.io.*;

public class DayOne {
    public static void main(String[] args) {
        partOne();
        // partTwo();
    }

    static void partOne() {
        try {
            // Scanner sc = new Scanner(new File("Day1/sample.txt"));
            Scanner sc = new Scanner(new File("Day1/input.txt"));
            int max = 0, curr = 0;
            while (sc.hasNext()) {
                String line = sc.nextLine();
                if (line.equals("")) {
                    max = Math.max(max, curr);
                    curr = 0;
                    continue;
                }
                curr += Integer.parseInt(line);
            }
            System.out.println(max);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void partTwo() {
        try {
            // Scanner sc = new Scanner(new File("Day1/sample.txt"));
            Scanner sc = new Scanner(new File("Day1/input.txt"));
            List<Integer> list = new ArrayList();
            int curr = 0;

            while(sc.hasNext()) {
                String line = sc.nextLine();
                if(line.equals("")) {
                    list.add(curr);
                    curr = 0;
                    continue;
                }
                curr += Integer.parseInt(line);
            }
            list.add(curr);

            Collections.sort(list, Collections.reverseOrder());
            System.out.println(list.get(0) + list.get(1) + list.get(2));
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}