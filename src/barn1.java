/*
ID: alexyjc1
LANG: JAVA
TASK: barn1
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class barn1 {
    public static void main(String[] args) throws IOException{
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        //BufferedReader f = new BufferedReader(new FileReader("/Users/alex/IdeaProjects/USACO stuff/src/barn1.in"));
        BufferedReader f = new BufferedReader(new FileReader("barn1.in"));

        // input file name goes above
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/alex/IdeaProjects/USACO stuff/src/barn1.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));

        String[] e = f.readLine().split(" ");
        int NumBoards = Integer.parseInt(e[0]);
        int NumStalls = Integer.parseInt(e[1]);
        int Occupied = Integer.parseInt(e[2]);

        int[] stalls = new int[Occupied];

        ArrayList<int[]> gaps = new ArrayList<>();

        for (int i = 0; i < Occupied; i++) {
            stalls[i] = Integer.parseInt(f.readLine());
        }

        Arrays.sort (stalls);

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - stalls[i - 1] > 1) {
                gaps.add (new int[] {stalls[i - 1], stalls[i]} );
            }
        }

        Collections.sort(gaps, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                System.out.println("Comparing: "+Arrays.toString(o1) + "  and  " + Arrays.toString(o2));
                if(o1[1] - o1[0] > o2[1] - o2[0]) {
                    return 1;
                }
                else if(o1[1] - o1[0] == o2[1] - o2[0]) {
                    return 0;
                }
                else if(o1[1] - o1[0] < o2[1] - o2[0]) {
                    return -1;
                }
                return -1;
            }
        });

        for(int[] stall :gaps){
            System.out.println(Arrays.toString(stall));
        }


        int boards = gaps.size()+1;
        int stallsCovered = Occupied;

        while (boards > NumBoards) {
            //remove smallest gap
            int[] g = gaps.remove(0);
            //add its size to stallsCovered
            stallsCovered += g[1] - g[0] -1;
            //remove a board
            boards--;
            System.out.println("boards:  " + boards + " , stallsCovered: "+stallsCovered);
        }

        out.println(stallsCovered);
        out.close();
    }
}
