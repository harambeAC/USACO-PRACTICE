package Chapter_1;/*
ID: alexyjc1
LANG: JAVA
TASK: Chapter_1.pprime
*/

import java.io.*;
import java.util.*;

class pprime {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        //BufferedReader f = new BufferedReader(new FileReader("/Users/alex/IdeaProjects/USACO stuff/src/Chapter_1.pprime.in"));
        BufferedReader f = new BufferedReader(new FileReader("Chapter_1.pprime.in"));

        // input file name goes above
        //out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/alex/IdeaProjects/USACO stuff/src/Chapter_1.pprime.out")));
        out = new PrintWriter(new BufferedWriter(new FileWriter("Chapter_1.pprime.out")));

        String[] arr = f.readLine().split(" ");

        a = Integer.parseInt(arr[0]);
        b = Integer.parseInt(arr[1]);

        generatePalindromes();

        out.close();                                  // close the output file
    }

    static int a;
    static int b;

    static PrintWriter out;

    public static void generatePalindromes(){
        generatePalindromes1Digit();
        generatePalindromes2Digit();
        generatePalindromes3Digit();
        generatePalindromes4Digit();
        generatePalindromes5Digit();
        generatePalindromes6Digit();
        generatePalindromes7Digit();
        generatePalindromes8Digit();
    }

    public static void generatePalindromes8Digit(){ // from 5 to 100,000,000
        for(int i = 1; i < 10; i++){
            for(int j = 0; j < 10; j++){
                for(int k = 0; k < 10; k++){
                    for(int l = 0; l < 10; l++) {
                        int num = 10000000 * i + 1000000 * j + 100000 * k + 10000 * l + 1000 * l + 100 * k + 10 * j + i;

                        if (num >= a && num <= b && isPrime(num)) {
                            System.out.println(num);
                            out.println(num);

                        }
                    }

                }
            }
        }
    }

    public static void generatePalindromes7Digit(){ // from 5 to 100,000,000
        for(int i = 1; i < 10; i++){
            for(int j = 0; j < 10; j++){
                for(int k = 0; k < 10; k++){
                    for(int l = 0; l < 10; l++) {

                        int num = 1000000 * i + 100000 * j + 10000 * k + 1000 * l + 100 * k + 10 * j + i;

                        if (num >= a && num <= b && isPrime(num)) {
                            System.out.println(num);
                            out.println(num);

                        }
                    }
                }
            }
        }
    }

    public static void generatePalindromes6Digit(){ // from 5 to 100,000,000
        for(int i = 1; i < 10; i++){
            for(int j = 0; j < 10; j++){
                for(int k = 0; k < 10; k++){
                    int num = 100000 * i + 10000 * j + 1000 * k + 100 * k + 10 * j + i;

                    if (num >= a && num <= b && isPrime(num)) {
                        System.out.println(num);
                        out.println(num);
                    }
                }
            }
        }
    }

    public static void generatePalindromes5Digit(){ // from 5 to 100,000,000
        for(int i = 1; i < 10; i++){
            for(int j = 0; j < 10; j++){
                for(int k = 0; k < 10; k++){
                    int num = 10000 * i + 1000 * j + 100 * k + 10 * j + i;

                    if (num >= a && num <= b && isPrime(num)) {
                        System.out.println(num);
                        out.println(num);

                    }
                }
            }
        }
    }

    public static void generatePalindromes4Digit(){ // from 5 to 100,000,000
        for(int i = 1; i < 10; i++){
            for(int j = 0; j < 10; j++){
                int num = 1000 * i + 100 * j + 10 * j + i;

                if (num >= a && num <= b && isPrime(num)) {
                    System.out.println(num);
                    out.println(num);

                }
            }
        }
    }

    public static void generatePalindromes3Digit(){ // from 5 to 100,000,000
        for(int i = 1; i < 10; i++){
            for(int j = 0; j < 10; j++){
                int num = 100 * i + 10 * j + + i;

                if (num >= a && num <= b && isPrime(num)) {
                    System.out.println(num);
                    out.println(num);

                }
            }
        }
    }

    public static void generatePalindromes2Digit(){ // from 5 to 100,000,000
        for(int i = 1; i < 10; i++){
            int num = 10 * i + i;

            if (num >= a && num <= b && isPrime(num)) {
                System.out.println(num);
                out.println(num);
            }
        }
    }

    public static void generatePalindromes1Digit(){ // from 5 to 100,000,000
        for(int i = 5; i < 10; i++){
            if (i >= a && i <= b && isPrime(i)) {
                System.out.println(i);
                out.println(i);

            }
        }
    }

    public static boolean isPrime(int num){
        for(int i = 2; i<Math.sqrt(num)+1; i++){
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(String s){
        if(s.length() == 0 || s.length() == 1){
            return true;
        }
        if(s.charAt(0) != s.charAt(s.length()-1)){
            return false;
        }

        return isPalindrome(s.substring(1, s.length()-1));
    }
}