import java.io.*;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class shuffle {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("/Users/alex/IdeaProjects/USACO stuff/src/shuffle.in"));
        //BufferedReader f = new BufferedReader(new FileReader("shuffle.in"));

        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/alex/IdeaProjects/USACO stuff/src/shuffle.out")));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));


        // Use StringTokenizer vs. readLine/split -- lots faster
        int N = Integer.parseInt(f.readLine());
        String[] line = f.readLine().split(" ");

        int[] positions = new int[N];
        for(int i = 0; i<N; i++){
            positions[i] = 1;
        }

        for(int i = 0; i<N; i++){
            positions[i]--; //position of original cow
            positions[Integer.parseInt(line[i])-1]++; // place cow at i moves to
            System.out.println(Arrays.toString(positions));
        }

        int num = 0;

        for(int i =0; i<N; i++){
            if(positions[i] != 0){
                num++;
            }
        }

        out.println(num);
        out.close();
    }
}
