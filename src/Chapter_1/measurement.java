package Chapter_1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class measurement {
    public static void main(String[] args) throws IOException
    {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        //BufferedReader f = new BufferedReader(new FileReader("/Users/alex/IdeaProjects/USACO stuff/src/Chapter_1.measurement.in"));
        BufferedReader f = new BufferedReader(new FileReader("Chapter_1.measurement.in"));

        // input file name goes above
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/alex/IdeaProjects/USACO stuff/src/Chapter_1.measurement.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Chapter_1.measurement.out")));


        // Use StringTokenizer vs. readLine/split -- lots faster
        String s = f.readLine();
        String[] arr = s.split(" ");
        // Get line, break into tokens
        int N = Integer.parseInt(arr[0]);
        int G = Integer.parseInt(arr[1]);

        int[][] entrylog = new int[N][3];
        int maxCow = -5;

        for(int i = 0; i<N; i++){

            s = f.readLine();
            String[] temp = s.split(" ");
            int[] entry = new int[3];

            for(int j = 0; j<=2; j++){
                entry[j] = Integer.parseInt(temp[j]);
            }

            if(Integer.parseInt(temp[1]) >= maxCow){
                maxCow = Integer.parseInt(temp[1]);
            }

            entrylog[i] = entry;
        }

        sortbyColumn(entrylog, 0);

        System.out.println(Arrays.deepToString(entrylog));

        int[][] Matrix = new int[maxCow][entrylog[entrylog.length-1][0] + 1];

        for (int row = 0; row < Matrix.length; row++) {
            Matrix[row][0] = G;
        }

        int entryIndex = 0;
        ArrayList<Integer> PrevMaxCows = new ArrayList<>();

        int COUNT = 0;

        for(int col = 1; col < Matrix[0].length; col++) {

            for (int row = 0; row < Matrix.length; row++) { // COPIES
                    Matrix[row][col] = Matrix[row][col - 1];
            }

            while (entryIndex < entrylog.length && entrylog[entryIndex][0] == col) { // UPDATES ROW
                int row = entrylog[entryIndex][1]-1;
                Matrix[row][col] = Matrix[row][col] + entrylog[entryIndex][2];

                entryIndex++;
            }

            ArrayList<Integer> maxcows = maxCows(Matrix, col);
            if (!PrevMaxCows.equals(maxcows)) {
                COUNT++;
            }
            PrevMaxCows = maxcows;

            System.out.println(Arrays.deepToString(Matrix));

        }

        //System.out.println(Arrays.deepToString(Matrix));

        out.println(COUNT);
        out.close();

    }

    public static ArrayList<Integer> maxCows(int[][] Matrix, int col){
        ArrayList<Integer> arr = new ArrayList<>();
        int max = 0;
        for(int i = 0; i<Matrix.length; i++){
            if(Matrix[i][col] > max){
                max = Matrix[i][col];
                arr.clear();
                arr.add(max);
            }
            if(Matrix[i][col] == max){
                arr.add(Matrix[i][col]);
            }
        }
        return arr;
    }

    public static void sortbyColumn(int arr[][], int col)
    {
        // Using built-in sort function Arrays.sort
        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            // Compare values according to columns
            public int compare(final int[] entry1,
                               final int[] entry2) {

                // To sort in descending order revert
                // the '>' Operator
                if (entry1[col] > entry2[col])
                    return 1;
                else
                    return -1;
            }
        });  // End of function call sort().
    }
}
