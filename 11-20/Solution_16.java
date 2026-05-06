// https://www.hackerrank.com/challenges/java-substring/problem?isFullScreen=true

import java.util.*;

public class Solution_16 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        int start = in.nextInt();
        int end = in.nextInt();

        in.close();
        // System.out.println(S.substring(start, end));
        String result = "";
        for (int i = start; i < end; i++) {
            result = result + S.charAt(i);
        }
        System.out.println(result);
    }
}