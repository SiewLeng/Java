// https://www.hackerrank.com/challenges/java-strings-introduction/problem?isFullScreen=true

import java.util.*;

public class Solution_1 {
    private static String upperCaseFirstLetter(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        /* Enter your code here. Print output to STDOUT. */
        int sum = A.length() + B.length();
        String isLarger = "No";
        if (A.compareTo(B) > 0) isLarger = "Yes";
        String output = upperCaseFirstLetter(A) +  " " + upperCaseFirstLetter(B);
        
        System.out.println(sum);
        System.out.println(isLarger);
        System.out.println(output);
    }
}
