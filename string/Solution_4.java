// https://www.hackerrank.com/challenges/java-string-reverse/problem?isFullScreen=true

import java.util.*;

public class Solution_4 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        /* Enter your code here. Print output to STDOUT. */
        int n = A.length();
        int end = n / 2;
        if (n % 2 == 1) end = (n + 1) / 2;
        for (int i = 0; i < end; i++) {
            if (A.charAt(i) != A.charAt(n - 1 - i)) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
