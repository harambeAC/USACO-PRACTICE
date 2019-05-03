//package Chapter_2;

/*
ID: alexyjc1
LANG: JAVA
TASK: frac1
*/

import java.io.*;
import java.util.*;

public class frac1 {

    public static void main(String[] args) throws IOException {
        //Use BufferedReader rather than RandomAccessFile; it's much faster
        //BufferedReader f = new BufferedReader(new FileReader("/Users/alex/IdeaProjects/USACO stuff/src/Chapter_2/frac1.in"));
        BufferedReader f = new BufferedReader(new FileReader("frac1.in"));

        // input file name goes above
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("/Users/alex/IdeaProjects/USACO stuff/src/Chapter_2/frac1.out"))));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("frac1.out"))));

        double N = Double.parseDouble(f.readLine());

        TreeMap<Double,String> nums = new TreeMap<>();

        for(double denom = N; denom > 0; denom--){
            for(double numer = 0.0; numer <= denom; numer++){
                int gcd = greatestCommonFactor((int)numer,(int)denom);

                nums.put(numer/denom, ((int)numer/gcd) + "/" + ((int)denom/gcd) );
            }
        }

        for(String s : nums.values()){
            out.println(s);
        }

        out.close();
    }

    public static int greatestCommonFactor(int num, int denom) {
        if (denom == 0) {
            return num;
        }
        return greatestCommonFactor(denom, num % denom);
    }
}


