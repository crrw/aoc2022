package Day12;
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) {
        partOne();
    }

    static void partOne() {
        try (Scanner sc = new Scanner(new File("Day12/sample.txt"))) {
            List<List<Character>> list = new ArrayList<>();
            Pair start = null;
            Pair end = null;

            while(sc.hasNext()) {
                String line = sc.nextLine();
                List<Character> ls = new ArrayList<>();
                for(int i=0; i<line.length(); i++) {
                    char c = line.charAt(i);
                    ls.add(c);
                }
                list.add(ls);
            }

            for(int i=0; i<list.size(); i++) {
                for(int j=0; j<list.get(i).size(); j++) {
                    char curr = list.get(i).get(j);
                    if(curr == 'S') {
                        start = new Pair(i, j);
                    }
                    if(curr == 'E') {
                        end = new Pair(i, j);
                    }
                }
            }


            int[][] arr = new int[list.size()][];
            for(int i=0; i<arr.length; i++) {
                arr[i] = new int[list.get(i).size()];
                for(int j=0; j<arr[i].length; j++) {
                    arr[i][j] = ((int) list.get(i).get(j));
                }
            }

            bfs(arr, start, end);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    static void bfs(int[][] arr, Pair start, Pair end) {
        int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        arr[start.first][start.second] = 'a' - 1;
        arr[end.first][end.second] = -1;

        Set<Pair> vis = new HashSet<>();

        Queue<Pair> queue = new LinkedList<>();
        queue.add(start);
        vis.add(start);
        int cnt = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int ii=0; ii<size; ii++) {
                Pair curr = queue.remove();
                System.out.println("!" + curr);
                int x = curr.first;
                int y = curr.second;

                if(arr[x][y] == -1) {
                    System.out.println(cnt + 1);
                    return;
                }

                for(int[] move : moves) {
                    int nx = x + move[0];
                    int ny = y + move[1];

                    Pair p = new Pair(nx, ny);
                    if(good(arr, nx, ny) && !vis.contains(p) && (arr[nx][ny] == arr[x][y] || arr[nx][ny] + 1 == arr[x][y] || arr[nx][ny] - 1 == arr[x][y])) {
                        queue.add(p);
                        vis.add(p);
                    }
                }
            }
            cnt++;
        }
        System.out.println(cnt);
        return;
    }

    static boolean good(int[][] arr, int i, int j) {
        return i >= 0 && i < arr.length && j >= 0 && j < arr[i].length;
    }
}

class Pair implements Comparable<Pair>{
    int first, second;

    public Pair (int first, int second){
        this.first = first;
        this.second = second;
      }

      @Override
      public String toString() {
        return "[" + this.first + "," + this.second + "]";
      }

      @Override
      public int hashCode() {
        return Objects.hash(this.first, this.second);
      }

      @Override
      public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null || getClass() != o.getClass()) return false;

        Pair that = (Pair) o;
        return this.first == that.first && this.second == that.second;
      }

      @Override
      public int compareTo(Pair p){
          if(first != p.first) return first - p.first;
          else return second - p.second;
      }
}