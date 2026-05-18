// https://www.hackerrank.com/challenges/java-arraylist/problem?isFullScreen=true

import java.util.*;

public class Solution_4 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int numOfLines = sc.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numOfLines; i++) {
            int n = sc.nextInt();
            ArrayList<Integer> numList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int num = sc.nextInt();
                numList.add(num);
            }
            list.add(numList);
        }
        numOfLines = sc.nextInt();
        for (int i = 0; i < numOfLines; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            if (x >= 0 && x <= list.size() - 1) {
                if (y >= 0 && y <= list.get(x).size() - 1) {
                    System.out.println("" + list.get(x).get(y));
                } else {
                    System.out.println("ERROR!");
                }
            } else {
                System.out.println("ERROR!");
            }
        }
    }
}
