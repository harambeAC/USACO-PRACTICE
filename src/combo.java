/*
ID: alexyjc1
LANG: JAVA
TASK: combo
*/

import java.io.*;
import java.security.Key;
import java.util.*;

public class combo {

    public static void main(String[] args) throws IOException{
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        //BufferedReader f = new BufferedReader(new FileReader("/Users/alex/IdeaProjects/USACO stuff/src/combo.in"));
        BufferedReader f = new BufferedReader(new FileReader("combo.in"));

        // input file name goes above
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/alex/IdeaProjects/USACO stuff/src/combo.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));

        int N = Integer.parseInt(f.readLine());

        String[] johnTemp = f.readLine().split(" ");
        int[] JOHN = new int[3];

        String[] masterTemp = f.readLine().split(" ");
        int[] MASTER = new int[3];

        for(int i = 0; i<johnTemp.length; i++){
            JOHN[i] = Integer.parseInt(johnTemp[i]);
            MASTER[i] = Integer.parseInt(masterTemp[i]);
        }

        //setup work is done


        List<int[]>set = new ArrayList<>();

        for(int i1 = JOHN[0] - 2; i1<=JOHN[0] + 2; i1++) {
            int newi1 = refactor(i1, N);

            for(int i2 = JOHN[1] - 2; i2<=JOHN[1] + 2; i2++) {
                int newi2 = refactor(i2, N);

                for(int i3 = JOHN[2] - 2; i3<=JOHN[2] + 2; i3++) {
                    int newi3 = refactor(i3, N);

                    int[] arr = new int[] {newi1, newi2, newi3};
                    //System.out.println(Arrays.deepToString(set.toArray()));

                    if(!contains(set,arr)) {
                        set.add(arr);
                    }
                }
            }
        }

        for(int i1 = MASTER[0] - 2; i1<=MASTER[0] + 2; i1++) {
            int newi1 = refactor(i1, N);

            for(int i2 = MASTER[1] - 2; i2<=MASTER[1] + 2; i2++) {
                int newi2 = refactor(i2, N);

                for(int i3 = MASTER[2] - 2; i3<=MASTER[2] + 2; i3++) {
                    int newi3 = refactor(i3, N);

                    int[] arr = new int[] {newi1, newi2, newi3};
                    //System.out.println(Arrays.deepToString(set.toArray()));

                    if(!contains(set,arr)) {
                        set.add(arr);
                    }
                }
            }
        }

        /*System.out.println(Arrays.deepToString(set.toArray()));


        ArrayList<int[]> x = new ArrayList<>();
        x.add(new int[] {1,2,3});
        x.add(new int[] {3,2,3});
        x.add(new int[] {2,2,3});

        System.out.println(contains(x, new int[] {2,2,4}));*/
        out.println(set.size());
        out.close();
    }

    public static boolean contains(List<int[]> list, int[] element){
        for(int i = 0; i<list.size(); i++){
            int[] e = list.get(i);
            if(checkIf2intArraysAreEqual(e,element)){
                return true;
            }
        }
        return false;
    }

    public static boolean checkIf2intArraysAreEqual(int[] e, int[] element){
        for(int i = 0; i<3; i++){
            if(e[i] != element[i]){
                return false;
            }
        }
        return true;
    }

    public static int refactor(int i, int N){
        while(i <= 0){
            i += N;
        }
        while(i > N){
            i -= N;
        }
        return i;
    }
}

