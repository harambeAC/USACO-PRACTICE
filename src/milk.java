/*
ID: alexyjc1
LANG: JAVA
TASK: milk
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class milk {
    public static void main(String[] args) throws IOException{
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        //BufferedReader f = new BufferedReader(new FileReader("/Users/alex/IdeaProjects/USACO stuff/src/milk.in"));
        BufferedReader f = new BufferedReader(new FileReader("milk.in"));

        // input file name goes above
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/alex/IdeaProjects/USACO stuff/src/milk.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));

        String[] e = f.readLine().split(" ");
        int UnitsLeft = Integer.parseInt(e[0]);
        int M = Integer.parseInt(e[1]);

        int[][] farmers = new int[M][2];

        // first value is price/unit
        // second value is number units


        for(int i = 0; i<M; i++){
            String[] temp = f.readLine().split(" ");
            farmers[i] = new int[]{Integer.parseInt(temp[0]), Integer.parseInt(temp[1])};
        }

        Arrays.sort(farmers, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] < o2[0] ? -1 : 1;
            }
        });

        int TotalCost = 0;
        int index = 0;

        System.out.println(Arrays.deepToString(farmers));

        while(UnitsLeft > 0 && index < farmers.length){

            int CostPerUnit = farmers[index][0];
            int NumUnits = farmers[index][1];

            int cost = CostPerUnit * NumUnits;
            if(UnitsLeft < NumUnits){ // not enough left over to cover entire
                TotalCost += UnitsLeft * CostPerUnit;

                UnitsLeft = 0;
            }
            else{ // enough left over to cover entire farmer
                UnitsLeft -= NumUnits;
                TotalCost += cost;
            }

            index++;
            System.out.println("Units Left : " + UnitsLeft + ", Cost so far: " + TotalCost);
        }

        out.println(TotalCost);
        out.close();
    }
}
