package Day5;

import java.util.*;
import java.io.*;

public class DayFive {
            static Stack<Character> one = new Stack<>();
            static Stack<Character> two = new Stack<>();
            static Stack<Character> three = new Stack<>();
            static Stack<Character> four = new Stack<>();
            static Stack<Character> five = new Stack<>();
            static Stack<Character> six = new Stack<>();
            static Stack<Character> seven = new Stack<>();
            static Stack<Character> eight = new Stack<>();
            static Stack<Character> nine = new Stack<>();

            static Map<Integer, Stack<Character>> mp = Map.of(1, one,
            2, two,
            3, three,
            4, four,
            5, five,
            6, six,
            7, seven,
            8, eight,
            9, nine);
    public static void main(String[] args) {
            one.push('s');
            one.push('t');
            one.push('h');
            one.push('f');
            one.push('w');
            one.push('r');

            two.push('s');
            two.push('g');
            two.push('d');
            two.push('q');
            two.push('w');

            three.push('b');
            three.push('t');
            three.push('w');

            four.push('d');
            four.push('r');
            four.push('w');
            four.push('t');
            four.push('n');
            four.push('q');
            four.push('z');
            four.push('j');

            five.push('f');
            five.push('b');
            five.push('h');
            five.push('g');
            five.push('l');
            five.push('v');
            five.push('t');
            five.push('z');

            six.push('l');
            six.push('p');
            six.push('t');
            six.push('c');
            six.push('v');
            six.push('b');
            six.push('s');
            six.push('g');

            seven.push('z');
            seven.push('b');
            seven.push('r');
            seven.push('t');
            seven.push('w');
            seven.push('g');
            seven.push('p');

            eight.push('n');
            eight.push('g');
            eight.push('m');
            eight.push('t');
            eight.push('c');
            eight.push('j');
            eight.push('r');

            nine.push('l');
            nine.push('g');
            nine.push('b');
            nine.push('w');
        partOne();
        sample();
    }

    static void partOne() {
            System.out.println(mp);

        try (Scanner sc = new Scanner(new File("Day5/input.txt"))) {
            while(sc.hasNext()) {
                String line = sc.nextLine();
                String[] moves = line.split(" ");

                int number = Integer.parseInt(moves[0]);
                int from = Integer.parseInt(moves[1]);
                int to = Integer.parseInt(moves[2]);

                StringBuilder order = new StringBuilder();
                for(int i=0; i<number; i++) {
                    var fromStk = mp.get(from);

                    order.append(fromStk.pop());
                }

                order.reverse();
                for(int i=0; i<order.length(); i++) {
                    char c = order.charAt(i);
                    var toStk = mp.get(to);

                    toStk.push(c);
                }
            }

            StringBuilder sb = new StringBuilder();
            for(Integer i : mp.keySet()) {
                var curr = mp.get(i);
                if(!curr.isEmpty()) {
                    sb.append(curr.peek());
                }
            }

            System.out.println(sb.reverse().toString());

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    static void sample() {
        try {
            Scanner sc = new Scanner(new File("Day5/sample.txt"));
                Stack<Character> one = new Stack<>();
                one.push('z');
                one.push('n');

                Stack<Character> two = new Stack<>();
                two.push('m');
                two.push('c');
                two.push('d');

                Stack<Character> three = new Stack<>();
                three.push('p');

                Map<Integer, Stack<Character>> mp = Map.of(1, one, 2, two, 3, three);

            while(sc.hasNext()) {
                String line = sc.nextLine();
                String[] moves = line.split(" ");

                int number = Integer.parseInt(moves[0]);
                int from = Integer.parseInt(moves[1]);
                int to = Integer.parseInt(moves[2]);

                for(int i=0; i<number; i++) {
                    var fromStk = mp.get(from);
                    var toStk = mp.get(to);

                    char pop = '-';
                    if(!fromStk.isEmpty()) {
                        pop = fromStk.pop();
                    }

                    if(pop != '-') {
                        toStk.push(pop);
                        pop = '-';
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for(Integer i : mp.keySet()) {
                var curr = mp.get(i);
                if(!curr.isEmpty()) {
                    sb.append(curr.peek());
                }
            }

            System.out.println(sb.reverse().toString());

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
