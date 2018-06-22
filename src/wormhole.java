/*
ID: alexyjc1
LANG: JAVA
TASK: wormhole
*/

import java.io.*;
import java.security.Key;
import java.util.*;

public class wormhole {

    public static void main(String[] args) throws IOException{
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("/Users/alex/IdeaProjects/USACO stuff/src/wormhole.in"));
        //BufferedReader f = new BufferedReader(new FileReader("wormhole.in"));

        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/alex/IdeaProjects/USACO stuff/src/wormhole.out")));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("wormhole.out"))));

        int N = Integer.parseInt(f.readLine());

        int[][] Coordinates = new int[N][2];

        for(int i = 0; i<N; i++){
            String line = f.readLine();
            System.out.println(line);
            String[] stuff = line.split( " ");

            Coordinates[i] = new int[]{Integer.parseInt(stuff[0]), Integer.parseInt(stuff[1])};
        }
        /*
        *Total ways of pairing are N/2
        *
        * */

        out.println(CountWaysStuck(Coordinates));
        out.close();
    }
}


public static int CountWaysStuck(int[][] Coordinates){
    return 0;
}
