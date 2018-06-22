import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class homework {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("/Users/alex/IdeaProjects/USACO stuff/src/homework.in"));
        //BufferedReader f = new BufferedReader(new FileReader("homework.in"));

        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/alex/IdeaProjects/USACO stuff/src/homework.out")));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("homework.out")));


        // Use StringTokenizer vs. readLine/split -- lots faster
        String s = f.readLine();
        // Get line, break into tokens
        int N = Integer.parseInt(s);

        s = f.readLine();
        String[] arr = s.split(" ");

        double sum = 0.0;

        Queue<Integer> q = new LinkedList<Integer>();

        for(int i = 0; i<N; i++) {
            int k = Integer.parseInt(arr[i]);
            q.offer(k);
            sum += k;
        }


        // average = sum/N


        double average = sum/N;
        int K = 1;
        double tempsum = sum;
        double prevsum = tempsum;
        double maxAve = 0.0;
        int maxK = 0;

        ArrayList<Integer> Ks = new ArrayList<>();

        while(K <= N-2){ // is the current average >= the previous average?

            prevsum = tempsum;
            tempsum -= q.poll();

            /*System.out.println("K = " + K +
                                " , number items = " + (N-K) +
                                " , tempave = " + tempsum/(N-K) +
                                " , prevave = " + prevsum/(N-K+1) +
                                " , tempsum = " + tempsum);*/



            if(tempsum/(N-K) > maxAve){
                maxAve = tempsum/(N-K);
                maxK = K;
            }
            if(tempsum == maxAve){
                Ks.add(K);
            }

            K++;
            //System.out.println(maxK);
        }
        /*
            for first set of data, 3,1,9,2,7
            remove 3         ave = 19/4       prevave = 22/5
            remove 3,1       ave = 18/3       prevave = 19/4
            remove 3,1,9     ave = 9/2        prevave = 18/3
         */

        Ks.add(maxK);

        for(int i : Ks) {
            out.println(i);                           // output result
        }

        out.close();                                  // close the output file
    }
}
