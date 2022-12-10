package Day8;

import java.util.*;
import java.io.*;

public class Day8 {
    public static void main(String[] args) {
        partTwo();
    }

    static void partOne() {
        try (Scanner sc = new Scanner(new File("Day8/sample.txt"))) {
            List<List<Integer>> list = new ArrayList();

            while (sc.hasNext()) {
                String s = sc.nextLine();
                List<Integer> ls = new ArrayList();

                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    int curr = c - '0';
                    ls.add(curr);
                }
                list.add(ls);
            }

            int[][] arr = new int[list.size()][];

            for (int i = 0; i < list.size(); i++) {
                int[] curr = new int[list.get(i).size()];
                arr[i] = curr;
                for (int j = 0; j < list.get(i).size(); j++) {
                    arr[i][j] = list.get(i).get(j);
                }
            }

            int n = arr.length, m = arr[0].length, cnt = 0;

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                        cnt++;
                        continue;
                    }
                    int curr = arr[i][j];

                    boolean check = true;

                    for (int ii = i + 1; ii < arr.length; ii++) {
                        if (arr[ii][j] >= curr) {
                            check = false;
                            break;
                        }
                    }

                    if (!check) {
                        check = true;
                        for (int ii = 0; ii < i; ii++) {
                            if (arr[ii][j] >= curr) {
                                check = false;
                                break;
                            }
                        }
                    }

                    if (!check) {
                        check = true;
                        for (int ii = j + 1; ii < arr[i].length; ii++) {
                            if (arr[i][ii] >= curr) {
                                check = false;
                                break;
                            }
                        }
                    }

                    if (!check) {
                        check = true;
                        for (int ii = 0; ii < j; ii++) {
                            if (arr[i][ii] >= curr) {
                                check = false;
                                break;
                            }
                        }
                    }
                    if (check) {
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void partTwo() {
        try (Scanner sc = new Scanner(new File("Day8/input.txt"))) {

            List<List<Integer>> list = new ArrayList();
            while (sc.hasNext()) {
                String s = sc.nextLine();
                List<Integer> ls = new ArrayList();

                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    int curr = c - '0';
                    ls.add(curr);
                }
                list.add(ls);
            }

            int[][] arr = new int[list.size()][];

            for (int i = 0; i < list.size(); i++) {
                int[] curr = new int[list.get(i).size()];
                arr[i] = curr;
                for (int j = 0; j < list.get(i).size(); j++) {
                    arr[i][j] = list.get(i).get(j);
                }
            }

            int max = 0, yMax = arr.length, xMax = arr[0].length;

            for (int y = 0; y < yMax; y++) {
                for (int x = 0; x < xMax; x++) {
                    int visible = 0;
                    if (y != 0 & y != yMax - 1 & x != 0 & x != xMax - 1) {
                        for (int j = y + 1; j < yMax; j++) {
                            visible++;
                            if (arr[j][x] >= arr[y][x]) {
                                break;
                            }
                        }
                        if (visible != 0) {
                            int counter = 0;
                            for (int j = y - 1; j >= 0; j--) {
                                counter++;
                                if (arr[j][x] >= arr[y][x]) {
                                    break;
                                }
                            }
                            visible *= counter;
                        }
                        if (visible != 0) {
                            int counter = 0;
                            for (int i = x + 1; i < xMax; i++) {
                                counter++;
                                if (arr[y][i] >= arr[y][x]) {
                                    break;
                                }
                            }
                            visible *= counter;
                        }
                        if (visible != 0) {
                            int counter = 0;
                            for (int i = x - 1; i >= 0; i--) {
                                counter++;
                                if (arr[y][i] >= arr[y][x]) {
                                    break;
                                }
                            }
                            visible *= counter;
                        }
                    }
                    if (visible > max) {
                        max = visible;
                    }
                }
            }

            System.out.println(max);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    static boolean good(int[][] arr, int i, int j) {
        return i >= 0 && i < arr.length && j >= 0 && j < arr[i].length;
    }
}
