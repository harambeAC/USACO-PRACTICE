/*
ID: alexyjc1
LANG: JAVA
TASK: dualpal
*/

import java.io.*;

public class dualpal {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        //BufferedReader f = new BufferedReader(new FileReader("/Users/alex/IdeaProjects/USACO stuff/src/dualpal.in"));
        BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));

        // input file name goes above
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/alex/IdeaProjects/USACO stuff/src/dualpal.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));

        String[] arr = f.readLine().split(" ");
        int N = Integer.parseInt(arr[0]);
        int S = Integer.parseInt(arr[1])+1;

        boolean Nfound = false;

        int count = 0;

        while(count < N) {
            int palCount = 0;
            for (int B = 2; B <= 10; B++) {
                if (isPalindrome(toBaseB(S, B))) {
                    palCount++;
                }
                if(palCount == 2){
                    out.println(S);
                    count++;
                    break;
                }
            }
            S++;
        }

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
