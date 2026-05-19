// https://www.hackerrank.com/challenges/java-dequeue/problem?isFullScreen=true

import java.util.*;

public class Solution_13 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); // size of numbers
        int n = sc.nextInt(); // size of subarray
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        Deque<Integer> deque = new LinkedList<>();
        Map<Integer, Integer> mapCount = new HashMap<>();
        int max = 0;
        for (int i = 0; i < m; i++) {
            if (i >= n) {
                // deque needs be maintained at subarray size
                int removedNum = deque.removeFirst();
                if (mapCount.containsKey(removedNum)) {
                    int oldCount = mapCount.get(removedNum);
                    if (oldCount == 1) {
                        mapCount.remove(removedNum);
                    } else {
                        mapCount.replace(removedNum, oldCount - 1);
                    }
                } 
            }
            deque.addLast(arr[i]);
            if (mapCount.containsKey(arr[i])) {
                int oldCount = mapCount.get(arr[i]);
                mapCount.replace(arr[i], oldCount + 1);
            } else {
                mapCount.put(arr[i], 1);
            }
            if (mapCount.size() > max) max = mapCount.size();
        }
        System.out.println(max);
    }
}