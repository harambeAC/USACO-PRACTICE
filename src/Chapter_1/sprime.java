package Chapter_1;/*
ID: alexyjc1
LANG: JAVA
TASK: Chapter_1.sprime
*/

import java.io.*;
import java.util.*;

class sprime {
    public static void main (String [] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/alex/IdeaProjects/USACO stuff/src/Chapter_1.sprime.in"));
        BufferedReader f = new BufferedReader(new FileReader("Chapter_1.sprime.in"));


        // input file name goes above
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/alex/IdeaProjects/USACO stuff/src/Chapter_1.sprime.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Chapter_1.sprime.out")));

        N = Integer.parseInt(f.readLine());

        nums = new ArrayList<>();

        System.out.println(isPrime(7));

        Node two = new Node(2);
        Node three = new Node(3);
        Node five = new Node(5);
        Node seven = new Node(7);

        for(int i : nums){
            out.println(i);
        }

        out.close();                                  // close the output file
    }

    public static List<Integer> nums;
    public static int N;

    public static class Node{
        public Node(int value) {
            //System.out.println(value);

            if(!isPrime(value)){
                return;
            }

            if ((int)Math.log10(value) == N-1) {
                nums.add(value);
                return;
            }

            //System.out.println(value);
            List<Node> nextNodes = new ArrayList<Node>();
            nextNodes.add(new Node(value * 10 + 1));
            nextNodes.add(new Node(value * 10 + 3));
            nextNodes.add(new Node(value * 10 + 5));
            nextNodes.add(new Node(value * 10 + 7));
            nextNodes.add(new Node(value * 10 + 9));
        }
    }


    private static boolean isPrime(int n) {
        for(int i=3; i<Math.sqrt(n) + 1; i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
}