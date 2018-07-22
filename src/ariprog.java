/*
ID: alexyjc1
LANG: JAVA
TASK: ariprog
*/

import java.io.*;
import java.util.*;

public class ariprog {

    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        //BufferedReader f = new BufferedReader(new FileReader("/Users/alex/IdeaProjects/USACO stuff/src/ariprog.in"));
        BufferedReader f = new BufferedReader(new FileReader("ariprog.in"));

        // input file name goes above
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/alex/IdeaProjects/USACO stuff/src/ariprog.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("ariprog.out"))));

        int N = Integer.parseInt(f.readLine());
        int M = Integer.parseInt(f.readLine());

        ArrayList<int[]> results = new ArrayList<>();
        boolean[] bisquares = new boolean[M*M*2+1];

        for(int p = 0; p<=M; p++){
            for(int q = 0; q<=M; q++){
                bisquares[p*p+q*q] = true;
            }
        }

        for(int a = 0; a<M*M*2; a++){
            if(bisquares[a]){
                search:
                for(int b = 1; a + b * (N-1) <= M*M*2; b++){
                    for(int i = 1; i<= N-1; i++){
                        if(!bisquares[a+b*i])
                            continue search;
                    }
                    results.add(new int[]{a,b});
                }
            }
        }

        if(results.size() == 0) {
            out.println("NONE");
            out.close();
            System.exit(0);
        }

        Collections.sort(results, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] < o2[1]) return -1;
                if(o1[1] > o2[1]) return 1;
                if(o1[0] < o2[0]) return -1;
                if(o1[0] < o2[0]) return 1;
                return 0;
            }
        });

        for(int i = 0; i<results.size(); i++){
            out.println(results.get(i)[0]+" "+results.get(i)[1]);
        }

        out.close();
    }
}


