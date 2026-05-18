// https://www.hackerrank.com/challenges/java-1d-array/problem?isFullScreen=true

import java.util.*;

public class Solution_5 {
    public static boolean canWinGame(int[] arr, int leap) {
        Set<Integer> visited = new HashSet<>(); // track the indexes visited
        Queue<Integer> queue = new LinkedList<>();

        if (arr[0] != 0) return false;
        queue.add(0); 
        visited.add(0);
        while (!queue.isEmpty()) {
            int index = queue.poll();
            if (index >= arr.length - 1) return true;

            ArrayList<Integer> indexes = new ArrayList<>();
            if (index - 1 >= 0) {
                indexes.add(index - 1);
            }
            if (index <= arr.length - 2) {
                indexes.add(index + leap);
                indexes.add(index + 1);
            }
            for (int i:indexes) {
                if (!visited.contains(i)) {
                    // not visited yet
                    if (i <= arr.length - 1) {
                        // within array and can be visited
                        if (arr[i] == 0) {
                            queue.add(i); 
                            visited.add(i);
                        }
                    } else {
                        // outside array
                        queue.add(i); 
                        visited.add(i);
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            int leap = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            if (canWinGame(arr, leap)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}