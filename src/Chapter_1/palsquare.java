package Chapter_1;/*
ID: alexyjc1
LANG: JAVA
TASK: Chapter_1.palsquare
*/

import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Scanner;

public class palsquare {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        //BufferedReader f = new BufferedReader(new FileReader("/Users/alex/IdeaProjects/USACO stuff/src/Chapter_1.palsquare.in"));
        BufferedReader f = new BufferedReader(new FileReader("Chapter_1.palsquare.in"));

        // input file name goes above
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/alex/IdeaProjects/USACO stuff/src/Chapter_1.palsquare.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Chapter_1.palsquare.out")));

        int B = Integer.parseInt(f.readLine());

        for(int N = 1; N<=300; N++){
            String SquaredinB = toBaseB(N*N,B);
            if(isPalindrome(SquaredinB)){
                System.out.println(N);

                out.println(toBaseB(N, B) + " " + SquaredinB);
            }
        }

        System.out.println(toBaseB(120,B));
        out.close();                                  // close the output file
    }




    public static String toBaseB( int number, int base )
    {
        return convert(number, base, 0, "" );
    }

    private static String convert( int number, int base, int position, String result )
    {
        char symbols[] = new char[] { '0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T' };
        if ( number < Math.pow(base, position + 1) )
        {
            return symbols[(number / (int)Math.pow(base, position))] + result;
        }
        else
        {
            int remainder = (number % (int)Math.pow(base, position + 1));
            return convert (  number - remainder, base, position + 1, symbols[remainder / (int)( Math.pow(base, position) )] + result );
        }
    }



    public static boolean isPalindrome(String number){
        if(number.length() == 1 || number.length() == 0){
            return true;
        }

        if(number.charAt(0) != number.charAt(number.length() - 1)){
            return false;
        }
        return isPalindrome(number.substring(1,number.length()-1));
    }
}