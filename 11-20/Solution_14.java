//https://www.hackerrank.com/challenges/java-negative-subarray/problem?isFullScreen=true

import java.util.*;

public class Solution_14 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        
        int count = 0;
        for (int subArrSize = 1; subArrSize <= arr.length; subArrSize++) {
            for (int start = 0; start <= arr.length - subArrSize; start++) {
                int sum = 0;
                for (int i = start; i < start + subArrSize; i++) {
                    sum += arr[i];
                }
                if (sum < 0) count += 1;
            }
        }
        System.out.println(count);
    }
}
