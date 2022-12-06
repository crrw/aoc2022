package Day6;

import java.util.*;
import java.io.*;

public class Day6 {
    public static void main(String[] args) {

        // partOne();
        partTwo();
    }

    static void partOne() {
        try(Scanner sc = new Scanner(new File("Day6/input.txt"))) {
            while(sc.hasNext()) {
                String line = sc.nextLine();
                LinkedList<Character> list = new LinkedList();

                for(int i=0; i<line.length(); i++) {
                    char c = line.charAt(i);

                    if(list.size() < 4) {
                        list.add(c);

                    } else {
                        list.add(c);

                        if(good(list)) {
                            System.out.println(i);
                            break;
                        }
                        list.removeFirst();
                    }
                }
            }


        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    static void partTwo() {
        try {
            Scanner sc = new Scanner(new File("Day6/input.txt"));

            while(sc.hasNext()) {
                String line = sc.nextLine();
                LinkedList<Character> list = new LinkedList<>();

                for(int i=0; i<line.length(); i++) {
                    char c = line.charAt(i);

                    if(list.size() < 14) {
                        list.add(c);

                    } else {
                        list.add(c);

                        if(isGood(list)) {
                            System.out.println(i);
                            break;
                        }

                        list.removeFirst();
                    }
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    static boolean good(List<Character> list) {
        assert(list.size() == 4);
        Set<Character> set = new HashSet();

        for(int i=0; i<list.size(); i++) {
            if(!set.add(list.get(i))) {
                return false;
            }
        }

        return true;
    }

    static boolean isGood(List<Character> list) {
        assert(list.size() == 14);
        Set<Character> set = new HashSet();

        for(int i=0; i<list.size(); i++) {
            if(!set.add(list.get(i))) {
                return false;
            }
        }
        return true;
    }
}
