package Day10;

import java.util.*;
import java.io.*;

public class Day10 {

    static int register = 1, cycle = 0, pos = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        partOne();
        partTwo();
    }

    static void partOne() {
        try (Scanner sc = new Scanner(new File("Day10/input.txt"))) {
            int cycle = 0, reg = 1, tot = 0;
            while (sc.hasNext()) {
                String[] line = sc.nextLine().split(" ");
                String op = line[0];

                if (op.equals("noop")) {
                    cycle++;

                    if (good(cycle)) tot += reg * cycle;
                    continue;
                }
                int value = Integer.parseInt(line[1]);

                cycle++;
                if (good(cycle)) tot += reg * cycle;
                cycle++;
                if (good(cycle)) tot += reg * cycle;

                reg += value;
            }

            System.out.println(tot);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void partTwo() {
        try (Scanner sc = new Scanner(new File("Day10/input.txt"))) {
            while (sc.hasNext()) {
                String[] s = sc.nextLine().split(" ");
                String op = s[0];

                if (op.equals("noop")) {
                    draw();
                    continue;
                }

                int value = Integer.parseInt(s[1]);
                draw();
                draw();

                register += value;
            }

            System.out.println(sb.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void draw() {
        if (cycle % 40 == 0) {
            pos = 0;
            sb.append("\n");
        }

        if (pos == register - 1 || pos == register || pos == register + 1) {
            sb.append("#");
        } else {
            sb.append(".");
        }
        pos++;
        cycle++;
    }

    private static boolean good(int cycle) {
        return cycle % 40 == 20;
    }
}
