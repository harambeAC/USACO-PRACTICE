package Chapter_1;/*
ID: alexyjc1
LANG: JAVA
TASK: Chapter_1.numtri
*/

import java.io.*;
import java.util.*;

class numtri {
    public static void main (String [] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/alex/IdeaProjects/USACO stuff/src/Chapter_1.numtri.in"));
        BufferedReader f = new BufferedReader(new FileReader("Chapter_1.numtri.in"));

        // input file name goes above
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/alex/IdeaProjects/USACO stuff/src/Chapter_1.numtri.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Chapter_1.numtri.out")));

        int N = Integer.parseInt(f.readLine());

        int[][] triangle = new int[N][];

        for(int i = 0; i<N; i++) {
            String[] nums = f.readLine().split(" ");
            int[] numbers = new int[nums.length];
            for (int j = 0; j < nums.length; j++) {
                numbers[j] = Integer.parseInt(nums[j]);
            }
            triangle[i] = numbers;
        }
        //System.out.println(Arrays.deepToString(triangle));

        for(int i = N-1; i>0; i--){
            for(int j = 0; j<triangle[i].length-1; j++){
                triangle[i-1][j] = Math.max(
                        triangle[i][j]+triangle[i-1][j]
                        ,triangle[i][j+1]+triangle[i-1][j]
                );
            }
        }

        //System.out.println(Arrays.deepToString(triangle));

        out.println(triangle[0][0]);
        out.close();                                  // close the output file
    }


}