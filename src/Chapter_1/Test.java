package Chapter_1;/*
ID: your_id_here
LANG: JAVA
TASK: test
*/

import java.io.*;
import java.util.*;

class Test {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("/Users/alex/IdeaProjects/USACO stuff/src/test.in"));
        //BufferedReader f = new BufferedReader(new FileReader("test.in"));

        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/alex/IdeaProjects/USACO stuff/src/test.out")));
        ///PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));


        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        String s = st.nextToken();
        out.println(s);                           // output result
        out.close();                                  // close the output file
    }
}