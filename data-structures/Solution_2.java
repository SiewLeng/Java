// https://www.hackerrank.com/challenges/java-negative-subarray/problem?isFullScreen=true

import java.util.*;

public class Solution_2 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.nextLine();
        s += sc.nextLine();
        String[] arrString = s.split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(arrString[i]);
        }
        int subArraySize = 1; 
        int count = 0;
        while (subArraySize <= arr.length) {
            int subArraySum = 0; 
            for (int i = 0; i < subArraySize; i++) {
                subArraySum += arr[i];
            }
            if (subArraySum < 0) {
                count++;
            }
            // uses fixed sliding window of fixed size - subArraySize
            for (int i = subArraySize; i < arr.length; i++) {
                subArraySum = arr[i] + subArraySum - arr[i - subArraySize];
                if (subArraySum < 0) {
                    count++;
                }
            }
            subArraySize++;
        }
        System.out.println(count);
    }
}
