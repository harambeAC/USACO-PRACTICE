package Chapter_1;/*
ID: alexyjc1
LANG: JAVA
TASK: Chapter_1.milk2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class milk2 {
    public static void main(String[] args) throws IOException{
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        //BufferedReader f = new BufferedReader(new FileReader("/Users/alex/IdeaProjects/USACO stuff/src/Chapter_1.milk2.in"));
        BufferedReader f = new BufferedReader(new FileReader("Chapter_1.milk2.in"));

        // input file name goes above
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/alex/IdeaProjects/USACO stuff/src/Chapter_1.milk2.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Chapter_1.milk2.out")));


        // Use StringTokenizer vs. readLine/split -- lots faster
        int N = Integer.parseInt(f.readLine());
        ArrayList<int[]> entries = new ArrayList<>();


        boolean restart = true;

        for(int i = 0; i<N; i++) {
            String s = f.readLine();
            String[] arr = s.split(" ");
            int start = Integer.parseInt(arr[0]);
            int end = Integer.parseInt(arr[1]);
            entries.add(new int[] {start,end});
        }

        sortbyStart(entries);

        System.out.println(Arrays.deepToString(entries.toArray()));

        int low = entries.get(0)[0];
        int high = entries.get(0)[1];
        int maxtime = high-low;
        int maxidle = 0;

        for(int i = 0; i<N; i++) {
            int start = entries.get(i)[0];
            int end = entries.get(i)[1];

            if (start <= high) {
                high = Math.max(end, high);
            } else {
                maxtime = Math.max(maxtime, high-low);
                maxidle = Math.max(maxidle, start-high);
                low = start;
                high = end;
            }
        }

        out.println(maxtime + " " + maxidle);
        out.close();
    }

    public static void sortbyStart(ArrayList<int[]> arr)
    {
        // Using built-in sort function Arrays.sort
        Collections.sort(arr, new Comparator<int[]>() {

            @Override
            // Compare values according to columns
            public int compare(int[] entry1,
                               int[] entry2) {

                // To sort in descending order revert
                // the '>' Operator
                if (entry1[0] > entry2[0])
                    return 1;
                else
                    return -1;
            }
        });  // End of function call sort().
    }
}
