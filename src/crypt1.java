/*
ID: alexyjc1
LANG: JAVA
TASK: crypt1
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class crypt1 {
    public static void main(String[] args) throws IOException{
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        //BufferedReader f = new BufferedReader(new FileReader("/Users/alex/IdeaProjects/USACO stuff/src/crypt1.in"));
        BufferedReader f = new BufferedReader(new FileReader("crypt1.in"));

        // input file name goes above
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/alex/IdeaProjects/USACO stuff/src/crypt1.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));

        int N = Integer.parseInt(f.readLine());

        String[] temp = f.readLine().split(" ");
        int[] digits = new int[N];

        for(int i = 0; i<temp.length; i++){
            digits[i] = Integer.parseInt(temp[i]);
        }


        //setup work is done. We now have an array of possible digits

        int CNT = 0;

        for(int A : digits){
            for(int B : digits){
                for(int C : digits){
                    for(int D : digits){
                        for(int E : digits){
                            int ABC = 100*A + 10*B + C;
                            int DE = 10*D + E;
                            if(doesContain((E*ABC)+"",temp)
                               && doesContain((D*ABC)+"",temp)
                               && doesContain((DE*ABC)+"",temp)
                               && String.valueOf(ABC*DE).length()==4
                               && String.valueOf(ABC*D).length()==String.valueOf(ABC*E).length()
                               && String.valueOf(ABC*D).length()==3){
                                CNT++;
                                System.out.println("ABC = " + ABC + " , DE = " + DE);
                            }
                        }
                    }
                }
            }
        }

        out.println(CNT);
        out.close();
    }

    public static boolean doesContain(String num, String[] digits){

        for(int i = 0; i<num.length(); i++){
            if(!contains(num.substring(i,i+1), digits)){
                return false;
            }
        }
        return true;
    }

    public static boolean contains(String digit, String[] digits){
        for(String dig : digits){
            if(digit.equals(dig)) {
                return true;
            }
        }
        return false;
    }
}
