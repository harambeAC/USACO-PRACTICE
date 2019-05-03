package Chapter_1;/*
ID: alexyjc1
LANG: JAVA
TASK: Chapter_1.skidesign
*/

import java.io.*;
import java.lang.reflect.Array;
import java.security.Key;
import java.util.*;

public class skidesign {

    static ArrayList<ArrayList<int[]>> wormholePairings = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        //BufferedReader f = new BufferedReader(new FileReader("/Users/alex/IdeaProjects/USACO stuff/src/Chapter_1.skidesign.in"));
        BufferedReader f = new BufferedReader(new FileReader("Chapter_1.skidesign.in"));

        // input file name goes above
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/alex/IdeaProjects/USACO stuff/src/Chapter_1.skidesign.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("Chapter_1.skidesign.out"))));

        int N = Integer.parseInt(f.readLine());

        int[] hills = new int[N];

        for (int i = 0; i < N; i++) {
            hills[i] = Integer.parseInt(f.readLine());
        }
        //System.out.println(Arrays.toString(hills));


//        while(hills[hills.length-1] - hills[0] > 17){
//            hills[hills.length-1]--;
//            hills[0]++;
//        }

        int minimumCost = Integer.MAX_VALUE;

        for(int i = 0; i<83; i++){  // try every inteveral of 17
            int cost = 0;
            for(int index = 0; index<N; index++){
                if(hills[index] < i){
                    cost += (i-hills[index])*(i-hills[index]);
                }
                else if(hills[index] > i+17){
                    cost += (hills[index] - (i+17))*(hills[index] - (i+17));
                }
            }
            System.out.println(cost);

            minimumCost = Math.min(minimumCost,cost);
        }

        System.out.println(Arrays.toString(hills));

        out.println(minimumCost);
        out.close();
    }
}


