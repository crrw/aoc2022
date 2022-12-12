package Day11;

import java.util.*;
import java.util.function.BiFunction;

class Main {

    static int ROUNDS = 20;

    List<Data> input = List.of(
            new Data(0, new ArrayList<>(Arrays.asList(80L)), "* 5", 2, 4, 3, 0), // 0
            new Data(1, new ArrayList<>(Arrays.asList(75L, 83L, 74L)), "+ 7", 7, 5, 6, 0), // 1
            new Data(2, new ArrayList<>(Arrays.asList(86L, 67L, 61L, 96L, 52L, 63L, 73L)), "+ 5", 3, 7, 0, 0), // 2
            new Data(3, new ArrayList<>(Arrays.asList(85L, 83L, 55L, 85L, 57L, 70L, 85L, 52L)), "+ 8", 17, 1, 5, 0), // 3
            new Data(4, new ArrayList<>(Arrays.asList(67L, 75L, 91L, 72L, 89L)), "+ 4", 11, 3, 1, 0), // 4
            new Data(5, new ArrayList<>(Arrays.asList(66L, 64L, 68L, 92L, 68L, 77L)), "* 2", 19, 6, 2, 0), // 5
            new Data(6, new ArrayList<>(Arrays.asList(97L, 94L, 79L, 88L)), "square ", 5, 2, 7, 0), // 6
            new Data(7, new ArrayList<>(Arrays.asList(77L, 85L)), "+ 6", 13, 4, 0, 0) // 7
    );

    List<Data> sample = List.of(
            new Data(0, new ArrayList<>(Arrays.asList(79L, 98L)), "* 19", 23, 2, 3, 0), // 0
            new Data(1, new ArrayList<>(Arrays.asList(54L, 65L, 75L, 74L)), "+ 6", 19, 2, 0, 0), // 1
            new Data(2, new ArrayList<>(Arrays.asList(79L, 60L, 97L)), "square ", 13, 1, 3, 0), // 2
            new Data(3, new ArrayList<>(Arrays.asList(74L)), "+ 3", 17, 0, 1, 0) // 3
    );


    static BiFunction<Long, Long, Long> MUL = (a, b) -> a * b;
    static BiFunction<Long, Long, Long> ADD = (a, b) -> a + b;

    Map<String, BiFunction<Long, Long, Long>> ops = Map.of(
            "*", MUL,
            "+", ADD);

    public static void main(String[] args) throws InterruptedException {
        Main m = new Main();
        m.f();
    }

    void f() throws InterruptedException {
        Main m1 = new Main();
        // Data[] arr = new Data[m1.input.size()];
        // for(int i=0; i<arr.length; i++) {
        //     arr[i] = m1.input.get(i);
        // }
        // int n = arr.length;

        Data[] sample = new Data[m1.sample.size()];
        for(int i=0; i<sample.length; i++) {
            sample[i] = m1.sample.get(i);
        }
        int n = sample.length;

        for(int rr=1; rr<=ROUNDS; rr++) {
            for(int monkey=0; monkey<n; monkey++) {
                Data curr = sample[monkey];
                sample[monkey].activity++;
                String operation = curr.operation;

                List<Long> items = curr.startingItems;
                int test = curr.test;
                int ifTrue = curr.ifTrue;
                int ifFalse = curr.ifFalse;

                while(!items.isEmpty()) {
                    String op = operation.split(" ")[0];
                    long newItem = items.remove(0);
                    long value = 1;
                    if(op.equals("square")) {
                        op = "*";
                        value = newItem;
                    } else {
                        value = Integer.parseInt(curr.operation.split(" ")[1]);
                    }

                    BiFunction<Long, Long, Long> doStuff = ops.get(op);
                    long postProcessing = doStuff.apply(newItem, value) / 3;
                    if(newItem == 0) {
                        System.out.println(items);
                        System.out.println("!" + newItem);
                    }

                    if(postProcessing % test == 0) {
                        sample[ifTrue].startingItems.add(postProcessing);
                        sample[ifTrue].activity++;
                    } else {
                        sample[ifFalse].startingItems.add(postProcessing);
                        sample[ifFalse].activity++;
                    }
                }
            }
            // System.out.println("ROUND" + rr);
            // for(int i=0; i<sample.length; i++) {
            //     System.out.println(sample[i]);
            // }
        }

        Arrays.sort(sample, (a, b) -> b.activity - a.activity);
        for(int i=0; i<sample.length; i++) {
            System.out.println(sample[i]);
        }

        System.out.println(sample[0].activity * sample[1].activity);
    }
}

class Data {
    int idx;
    List<Long> startingItems;
    String operation;
    int test;
    int ifTrue;
    int ifFalse;
    int activity;

    public Data(int idx, List<Long> startingItems, String operation, int test, int ifTrue, int ifFalse, int activity) {
        this.idx = idx;
        this.startingItems = startingItems;
        this.operation = operation;
        this.test = test;
        this.ifTrue = ifTrue;
        this.ifFalse = ifFalse;
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "[" + "idx=" + idx + ","
                + "startingItems=" + startingItems + ","
                + "operation=" + operation + ","
                + "test=" + test + ","
                + "ifTrue=" + ifTrue + ","
                + "ifFalse=" + ifFalse + ","
                + "activity=" + activity + "]\n";
    }
}