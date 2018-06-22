/*
ID: alexyjc1
LANG: JAVA
TASK: transform
*/

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class transform {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        //BufferedReader f = new BufferedReader(new FileReader("/Users/alex/IdeaProjects/USACO stuff/src/transform.in"));
        BufferedReader f = new BufferedReader(new FileReader("transform.in"));

        // input file name goes above
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/alex/IdeaProjects/USACO stuff/src/transform.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));


        // Use StringTokenizer vs. readLine/split -- lots faster
        // Get line, break into tokens
        int N = Integer.parseInt(f.readLine());

        boolean[][] before = new boolean[N][N];
        // @ = true, - = false

        for(int i = 0; i<N; i++){
            String s = f.readLine();
            for(int j = 0; j<N; j++){
                if(s.substring(j, j+1).equals("@")){
                    before[i][j] = true;
                }
            }
        }

        boolean[][] after = new boolean[N][N];
        for(int i = 0; i<N; i++){
            String s = f.readLine();
            for(int j = 0; j<N; j++){
                if(s.substring(j, j+1).equals("@")){
                    after[i][j] = true;
                }
            }
        }

        System.out.println(Arrays.deepToString(before));
        System.out.println(Arrays.deepToString(after));


        if(Arrays.deepEquals(rotate(before, 90), after)){
            out.println(1);
        } else if(Arrays.deepEquals(rotate(before, 180), after)){
            out.println(2);
        } else if(Arrays.deepEquals(rotate(before, 270), after)){
            out.println(3);
        } else if(Arrays.deepEquals(reflect(before), after)){
            out.println(4);
        } else if(Arrays.deepEquals(rotate(reflect(before), 90), after) ||
                  Arrays.deepEquals(rotate(reflect(before), 180), after) ||
                  Arrays.deepEquals(rotate(reflect(before), 270), after)){
            out.println(5);
        } else if(Arrays.deepEquals(before, after)){
            out.println(6);
        } else{
            out.println(7);
        }

        out.close();                                  // close the output file
    }

    public static boolean[][] rotate(boolean[][] arr, int deg){
        if(deg == 90){
            boolean[][] newarr = new boolean[arr.length][arr.length];
            for(int i = 0; i<arr.length; i++){
                for(int j = 0; j<arr.length; j++){
                    newarr[j][arr.length - i - 1]= arr[i][j];
                    //System.out.println(Arrays.deepToString(newarr) + "     " + i + " , " + j + " -> " + j + " , " + (arr.length-i-1));
                }
            }
            return newarr;
        }
        else if(deg == 180){
            return rotate(rotate(arr, 90),90);
        }
        else if(deg == 270){
            return rotate(rotate(arr,  180), 90);
        }
        return null;
    }

    public static boolean[][] reflect(boolean[][] arr){
        boolean[][] newarr = new boolean[arr.length][arr.length];
        for(int i = 0; i<arr.length; i++){
            for(int j = 0; j<arr.length; j++){
                newarr[i][j]= arr[i][arr.length-j-1];
                //System.out.println(Arrays.deepToString(newarr) + "     " + i + " , " + j + " -> " + j + " , " + (arr.length-i-1));
            }
        }
        return newarr;
    }
}
