// https://www.hackerrank.com/challenges/java-string-compare/problem?isFullScreen=true

import java.util.Scanner;

public class Solution_3 {

    private static int myCompareTo(String s1, String s2) {
        String shorter = s1;
        String longer = s2;
        boolean isS1Shorter = true;
        if (s2.length() < s1.length()) {
            shorter = s2;
            longer = s1;
            isS1Shorter = false;
        }
        int i = 0;
        while (i < shorter.length()) {
            int a = (int)shorter.charAt(i);
            int b = (int)longer.charAt(i);
            if (a < b) {
                if (isS1Shorter == true) return -1;
                if (isS1Shorter == false) return 1;
           }
           if (a > b) {
                if (isS1Shorter == true) return 1;
                if (isS1Shorter == false) return -1;
           }
           i++;
        }
        if (s1.length() == s2.length()) return 0;
        if (isS1Shorter == true) return -1;
        return 1;
    }

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        
        for (int start = 0; start <= s.length() - k; start++) {
            if (start == 0) {
                String sub = s.substring(start, start + k);
                smallest = sub;
                largest = sub;
            } else {
                String sub = s.substring(start, start + k);
                /* 
                if (sub.compareTo(smallest) < 0)  smallest = sub;
                if (sub.compareTo(largest) > 0) largest = sub;
                */
                if (myCompareTo(sub, smallest) < 0)  smallest = sub;
                if (myCompareTo(sub, largest) > 0) largest = sub;
            }
        }
        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
      
        System.out.println(getSmallestAndLargest(s, k));
    }
}