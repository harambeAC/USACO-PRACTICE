//package Chapter_2;

/*
ID: alexyjc1
LANG: JAVA
TASK: castle
*/

import java.io.*;
import java.util.*;

public class castle {

    public static void main(String[] args) throws IOException {
        //Use BufferedReader rather than RandomAccessFile; it's much faster
        //BufferedReader f = new BufferedReader(new FileReader("/Users/alex/IdeaProjects/USACO stuff/src/Chapter_2/castle.in"));
        BufferedReader f = new BufferedReader(new FileReader("castle.in"));

        // input file name goes above
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("/Users/alex/IdeaProjects/USACO stuff/src/Chapter_2/castle.out"))));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("castle.out"))));

        String[] MN = f.readLine().split(" ");
        M = Integer.parseInt(MN[0]);
        N = Integer.parseInt(MN[1]);

        group = new int[N][M];
        adj = new HashSet[M*N];
        marked = new int[M*N];
        for(int i=0; i<marked.length; i++){
            marked[i] = -1;
        }
        for(int i = 0; i<adj.length; i++){
            adj[i] = new HashSet<>();
        }

        for(int i = 0; i<N; i++){
            String[] arr = f.readLine().split(" ");
            for(int j = 0; j<M; j++){
                //[west, north, east, south]
                int id = i * M + j;

                String temp = Integer.toBinaryString(Integer.parseInt(arr[j]));

                while(temp.length() != 4){
                    temp = "0" + temp;
                }
                char[] walls = temp.toCharArray();
                if(walls[0] == '0'){ // south
                    adj[id].add(id+M);
                }
                if(walls[1] == '0'){ // east
                    adj[id].add(id+1);
                }
                if(walls[2] == '0'){
                    adj[id].add(id-M);
                }
                if(walls[3] == '0'){
                    adj[id].add(id-1);
                }
            }
        }

        int[] a = dfs();
        out.println(a.length);
        int max = 0;
        for(int i : a){
            if(i > max){
                max = i;
            }
        }
        System.out.println(Arrays.deepToString(group));
        out.println(max);

        int best = 0;
        int bestAtI = 0;
        int bestAtJ = 0;
        boolean bestDir = false;
        for(int j = 0; j < M;j++)
        {
            for(int i = N-1; i >= 0;i--)
            {
                if(i+1 < N && group[i][j] != group[i+1][j])
                {
                    int s = a[group[i][j]]+a[group[i+1][j]];

                    if(s > best)
                    {
                        best = s;
                        bestAtI = i+1;
                        bestAtJ = j;
                        bestDir = true;
                    }
                }

            }
            for(int i = N-1; i >= 0;i--)
            {
                if(j+1 < M && group[i][j] != group[i][j+1])
                {
                    int e = a[group[i][j]]+a[group[i][j+1]];
                    if(e > best)
                    {
                        best = e;
                        bestAtI = i;
                        bestAtJ = j;
                        bestDir = false;
                    }
                }
            }
        }
        out.println(best);
        out.println((bestAtI+1)+" "+(bestAtJ+1)+" "+(bestDir?"N":"E"));

        out.close();
    }

    static HashSet<Integer>[] adj;
    static int[] marked;
    static int M;
    static int N;
    static int[][] group;

    private static int[] dfs(){
        int count = 0;
        for(int i = 0; i<marked.length; i++){
            if(marked[i] == -1){
                dfs(i, count);
                count++;
            }
        }
        int[] components = new int[count];

        for(int i = 0; i<count; i++){
            for(int mark : marked){
                if(i == mark){
                    components[i]++;
                }
            }
        }
        return components;
    }

    private static void dfs(int v, int count){
        if(marked[v] == -1){
            marked[v] = count;
            group[v/M][v%M] = count;
            for(int w : adj[v]){
                dfs(w, count);
            }
        }
    }
}


