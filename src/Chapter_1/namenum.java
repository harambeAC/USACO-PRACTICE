package Chapter_1;/*
ID: alexyjc1
LANG: JAVA
TASK: Chapter_1.namenum
*/

import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Scanner;

public class namenum {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        //BufferedReader f = new BufferedReader(new FileReader("/Users/alex/IdeaProjects/USACO stuff/src/Chapter_1.namenum.in"));
        BufferedReader f = new BufferedReader(new FileReader("Chapter_1.namenum.in"));

        //Scanner acceptableNames = new Scanner(new File("/Users/alex/IdeaProjects/USACO stuff/src/dict.txt"));
        Scanner acceptableNames = new Scanner(new File("dict.txt"));

        // input file name goes above
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/alex/IdeaProjects/USACO stuff/src/Chapter_1.namenum.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Chapter_1.namenum.out")));

        ArrayList<String> acceptable = new ArrayList<>();
        while(acceptableNames.hasNext()){
            acceptable.add(acceptableNames.nextLine());
        }

        long num = Long.parseLong(f.readLine());

        boolean found = false;

        for(int i = 0; i<acceptable.size(); i++){
            if(toNum(acceptable.get(i)) == num){
                out.println(acceptable.get(i));
                found = true;
            }
        }

        if(!found) {out.println("NONE");}
        out.close();                                  // close the output file
    }

    public static long toNum(String name){
        long number = 0;
        for(int i = 0; i<name.length(); i++){
            number += Math.pow(10,i)*toDigit(name.charAt(name.length()-i-1));
        }
        return number;
    }

    public static long toDigit(char digit) {
        /*2: A,B,C     5: J,K,L    8: T,U,V
        3: D,E,F     6: M,N,O    9: W,X,Y
        4: G,H,I     7: P,R,S*/

        switch (digit){
            case 'A': return 2;
            case 'B': return 2;
            case 'C': return 2;

            case 'D': return 3;
            case 'E': return 3;
            case 'F': return 3;

            case 'G': return 4;
            case 'H': return 4;
            case 'I': return 4;

            case 'J': return 5;
            case 'K': return 5;
            case 'L': return 5;

            case 'M': return 6;
            case 'N': return 6;
            case 'O': return 6;

            case 'P': return 7;
            case 'R': return 7;
            case 'S': return 7;

            case 'T': return 8;
            case 'U': return 8;
            case 'V': return 8;

            case 'W': return 9;
            case 'X': return 9;
            case 'Y': return 9;
        }

        return 0;

    }
}