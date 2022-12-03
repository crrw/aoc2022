package Day3;

import java.util.*;
import java.io.*;

public class DayThree {
    public static void main(String[] args) {
        // partOne();
        partTwo();
    }

    static void partOne() {
        try {
            // Scanner sc = new Scanner(new File("Day3/sample.txt"));
            Scanner sc = new Scanner(new File("Day3/input.txt"));
            int count = 0;

            while (sc.hasNext()) {
                String line = sc.nextLine();
                assert (line.length() % 2 == 0);

                String first = line.substring(0, line.length() / 2);
                String second = line.substring(line.length() / 2);
                System.out.println(second);

                Set<Character> firstSeen = new HashSet();
                Set<Character> secondSeen = new HashSet();

                for (char c : first.toCharArray()) {
                    firstSeen.add(c);
                }

                for (char c : second.toCharArray()) {
                    if (firstSeen.contains(c) && !secondSeen.contains(c)) {
                        secondSeen.add(c);

                        if (isLowerCase(c)) {
                            count += c - 96;
                        } else {
                            count += c - 64 + 26;
                        }
                    }
                }

            }
            System.out.println(count);
        } catch (

        Exception e) {
            e.printStackTrace();
        }
    }

    static void partTwo() {
        try {
            // Scanner sc = new Scanner(new File("Day3/sample.txt"));
            Scanner sc = new Scanner(new File("Day3/input.txt"));

            StringBuilder sb = new StringBuilder();
            List<String> list = new ArrayList();
            int count = 0;

            while (sc.hasNext()) {
                String line = sc.nextLine();
                list.add(line);
            }

            for (int i = 0; i < list.size() - 2; i += 3) {
                String first = list.get(i);
                String second = list.get(i + 1);
                String third = list.get(i + 2);
                List<String> threes = List.of(first, second, third);

                System.out.println(first);
                System.out.println(second);
                System.out.println(third);

                Set<Character> check = convertToSet(first);
                threes.stream().skip(1).forEach(s -> check.retainAll(convertToSet(s)));

                for (char c : check) {
                    if (isLowerCase(c)) {
                        count += c - 96;
                    } else {
                        count += c - 64 + 26;
                    }
                }
            }
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static boolean isLowerCase(char c) {
        return c >= 'a' && c <= 'z';
    }

    static boolean isUpperCase(char c) {
        return c >= 'A' && c <= 'Z';
    }

    static Set<Character> convertToSet(String s) {
        Set<Character> set = new HashSet();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        return set;
    }
}
