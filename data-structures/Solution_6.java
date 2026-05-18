// http://hackerrank.com/challenges/java-list/problem?isFullScreen=true

import java.util.*;

public class Solution_6 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        int testcases = sc.nextInt();
        while (testcases >= 1) {
            sc.nextLine();
            String s = sc.nextLine();
            int index = sc.nextInt();
            if (s.toLowerCase().compareTo("insert") == 0) {
                int num = sc.nextInt();
                arr.add(index, num);
            } else if (s.toLowerCase().compareTo("delete") == 0) {
                arr.remove(index);
            }
            testcases--;
        }
        String out = "";
        for (int i: arr) {
            out += i + " "; 
        }
        System.out.println(out);
        sc.close();
    }
}
