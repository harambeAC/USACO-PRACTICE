package Chapter_1;/*
ID: alexyjc1
LANG: JAVA
TASK: Chapter_1.milk3
*/

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class milk3 {

    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/alex/IdeaProjects/USACO stuff/src/Chapter_1.milk3.in"));
        BufferedReader f = new BufferedReader(new FileReader("Chapter_1.milk3.in"));

        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/alex/IdeaProjects/USACO stuff/src/Chapter_1.milk3.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Chapter_1.milk3.out")));

        possibleValues = new HashSet<>();
        String[] temp = f.readLine().split(" ");
        int A = Integer.parseInt(temp[0]);
        int B = Integer.parseInt(temp[1]);
        int C = Integer.parseInt(temp[2]);

        maxLevels = new int[] {A,B,C};

        milkLevels = new int[3];
        milkLevels[2] = C; // Bucket C will be full

        visited = new HashMapSet();

        stack = new Stack<>();
        stack.push(milkLevels);

        visited.put(milkLevels, true);

        DFS();

        Object[] pv = possibleValues.toArray();

        Arrays.sort(pv);

        for(int i = 0; i<pv.length - 1; i++){
            int value = (int) pv[i];
            out.print(value + " ");
        }
        out.print(pv[pv.length-1]);
        out.print("\n");

        System.out.println(Arrays.toString(possibleValues.toArray()));

//        System.out.println(Arrays.toString(moveMilk(new int[]{0, 2, 8}, 2, 0)));

//        System.out.println(Arrays.toString(moveMilk(new int[]{8, 0, 2}, 1, 0)));
//        System.out.println(Arrays.toString(moveMilk(new int[]{8, 0, 2}, 2, 0)));
//        System.out.println(Arrays.toString(moveMilk(new int[]{8, 0, 2}, 2, 1)));
//        System.out.println(Arrays.toString(moveMilk(new int[]{8, 0, 2}, 0, 1)));
//        System.out.println(Arrays.toString(moveMilk(new int[]{8, 0, 2}, 0, 2)));
//        System.out.println(Arrays.toString(moveMilk(new int[]{8, 0, 2}, 1, 2)));


        out.close();
    }

    static int[] maxLevels;
    static int[] milkLevels;
    static HashSet<Integer> possibleValues;
    static HashMapSet visited;


    public static int[] moveMilk(int[] levels, int from, int to){
        int[] temp = levels.clone();
        temp[to] += levels[from];
        int difference = 0;
        int differenceAtTo = 0;
        if(temp[to] > maxLevels[to]){
            differenceAtTo = temp[to] - maxLevels[to];
            temp[to] = maxLevels[to];
            difference = temp[from] - temp[to];
        }
        //System.out.println(difference);
        if(difference < 0){
            return levels;
        }

        temp[from] = differenceAtTo;
        return temp;
    }


    public static List<int[]> getPermutations(int[] top){
        Comparator<int[]> c = new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                int total = 0;
                for (int i = 0; i < a.length; i++) {
                    total = a[i] - b[i];
                }
                return total;
            }
        };

        List<int[]> set = new ArrayList<int[]>();

        set.add(moveMilk(top,0,1));
        set.add(moveMilk(top,0,2));
        set.add(moveMilk(top,1,2));
        set.add(moveMilk(top,1,0));
        set.add(moveMilk(top,2,0));
        set.add(moveMilk(top,2,1));

        System.out.println(Arrays.deepToString(set.toArray()));

        if(visited.getOrDefault(top, false)){
            set.remove(top);
        }

        for(int[] trio : set){
            if(trio[0] == 0){
                possibleValues.add(trio[2]);
            }
        }

        return set;
    }

    static Stack<int[]> stack;

    public static void DFS(){
        int[] top = stack.peek();
        List<int[]> neighbors = getPermutations(top);
        System.out.println(Arrays.deepToString(stack.toArray()));
        System.out.println(visited.toString());
        for(int[] neighbor : neighbors){
            if (!visited.getOrDefault(neighbor, false)) {
                System.out.println("EXECUTING                          " + Arrays.toString(neighbor));
                stack.push(neighbor);
                visited.put(neighbor, true);
                DFS();
            }
        }
        stack.pop();
    }

    static class HashMapSet{
        ArrayList<int[]> keys;
        ArrayList<Boolean> values;

        public HashMapSet(){
            keys = new ArrayList<int[]>();
            values = new ArrayList<Boolean>();
        }

        public void put(int[] k, Boolean v){
            if(!isInKeys(k)){
                keys.add(k);
                values.add(v);
            }
        }

        public boolean isInKeys(int[] k){
            if(values.isEmpty()) return false;

            for(int i = 0; i<keys.size(); i++){
                if(equals(k, keys.get(i))){
                    return true;
                }
            }

            return false;
        }

        public int getIndexKeys(int[] k){
            if(values.isEmpty()) return -1;
            for(int i = 0; i<keys.size(); i++){
                if(equals(keys.get(i), k)){
                    return i;
                }
            }
            return -1;
        }

        public boolean equals(int[] a, int[] b){
            for(int j = 0; j<a.length; j++){
                if(a[j] != b[j]){
                    return false;
                }
            }
            return true;
        }

        public boolean getOrDefault(int[] k, boolean b){
            if(isInKeys(k)){
                int index = getIndexKeys(k);
                return values.get(index);
            }
            return b;
        }

        @Override
        public String toString() {
            String s = "[";
            for(int i = 0; i<values.size(); i++){
                s += "("+Arrays.toString(keys.get(i)) + " : " + values.get(i) + ")  ";
            }
            s+="]";
            return s;
        }
    }
}
