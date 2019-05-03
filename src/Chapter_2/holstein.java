package Chapter_2;

/*
ID: alexyjc1
LANG: JAVA
TASK: holstein
*/

import java.io.*;
import java.util.*;

public class holstein {

    public static void main(String[] args) throws IOException {
        //Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("/Users/alex/IdeaProjects/USACO stuff/src/Chapter_2/holstein.in"));
        //BufferedReader f = new BufferedReader(new FileReader("holstein.in"));

        // input file name goes above/
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("/Users/alex/IdeaProjects/USACO stuff/src/Chapter_2/holstein.out"))));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("holstein.out"))));

        int V = Integer.parseInt(f.readLine());

        String[] arr = f.readLine().split(" ");
        int[] reqs = new int[V];
        for(int i = 0; i<V; i++){
            reqs[i] = Integer.parseInt(arr[i]);

        }

        int G = Integer.parseInt(f.readLine());
        int[][] scoops = new int[G][V];

        for(int i = 0; i<G; i++){
            String[] temp = f.readLine().split(" +");
            for(int j = 0; j<V; j++){
                scoops[i][j] = Integer.parseInt(temp[j]);
            }
        }

        int[] bale = new int[reqs.length];
        visited = new HashSet<>();
        printStack(fill(reqs, bale, scoops, new Stack<int[]>()));

        out.close();
    }

    public static boolean isfilled(int[] a, int[] b){
        for(int i =0 ; i<a.length; i++){
            if(a[i] < b[i]){
                return false;
            }
        }
        return true;
    }

    static HashSet<Integer> visited;

    public static Stack<int[]> fill(int[] reqs, int[] bale, int[][] scoops, Stack<int[]> best){
        Stack<int[]> better = new Stack<>();
        System.out.println(Arrays.toString(bale));
        System.out.println(Arrays.deepToString(scoops));
        for(int sc = 0; sc<scoops.length; sc++){
            int[] scoop = scoops[sc];

            if(!isfilled(bale, reqs) && !visited.contains(sc)){
                visited.add(sc);
                add(bale, scoop);

                better.add(scoop);
                better.addAll(fill(reqs, bale, scoops, better));

                if(isfilled(bale, reqs)){
                    if(best.size() > better.size()){
                        better = best;
                    }
                    printStack(best);
                }
                subtract(bale, scoop);
            }
            visited.remove(sc);
        }
        return better;
    }

    private static void subtract(int[] test, int[] scoop) {
        for(int i = 0; i<test.length; i++){
            test[i] -= scoop[i];
        }
    }

    private static void add(int[] test, int[] scoop) {
        for(int i = 0; i<test.length; i++){
            test[i] += scoop[i];
        }
    }

    private static void printStack(Stack<int[]> stack){
        System.out.println("STACCKK ++++++ ");
        for(int[] frame : stack){
            System.out.println(Arrays.toString(frame));
        }
        System.out.println("--------------");

    }
}


