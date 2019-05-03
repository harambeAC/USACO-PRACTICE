//package Chapter_2;

/*
ID: alexyjc1
LANG: JAVA
TASK: sort3
*/

import java.io.*;
import java.util.*;

public class sort3 {

    public static void main(String[] args) throws IOException {
        //Use BufferedReader rather than RandomAccessFile; it's much faster
        //BufferedReader f = new BufferedReader(new FileReader("/Users/alex/IdeaProjects/USACO stuff/src/Chapter_2/sort3.in"));
        BufferedReader f = new BufferedReader(new FileReader("sort3.in"));

        // input file name goes above/
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("/Users/alex/IdeaProjects/USACO stuff/src/Chapter_2/sort3.out"))));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("sort3.out"))));

        int N = Integer.parseInt(f.readLine());

        int[] nums = new int[N];
        for(int i =0; i<N; i++){
            nums[i] = Integer.parseInt(f.readLine());
        }
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(sorted));

        int count = 0;
        for(int i =0; i<N; i++){
            if(nums[i] != sorted[i]){
                count++;
            }
        }
        System.out.println(count);
        if(count %2 == 0){
            out.println(count/2);
        }else{
            out.println(count/2 + 1);
        }
        out.close();
    }
}


