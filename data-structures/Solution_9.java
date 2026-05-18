// https://www.hackerrank.com/challenges/java-hashset/problem?isFullScreen=true

import java.util.*;

public class Solution_9 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Set<ArrayList<String>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split(" ");
            ArrayList<String> arr = new ArrayList<>();
            if (tokens[0].compareTo(tokens[1]) < 0) {
                arr.add(tokens[0]);
                arr.add(tokens[1]);
            } else {
                arr.add(tokens[1]);
                arr.add(tokens[0]);
            }
            set.add(arr);
            System.out.println(set.size());
        }
        sc.close();
    }
}
