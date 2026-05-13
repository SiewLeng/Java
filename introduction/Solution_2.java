// https://www.hackerrank.com/challenges/java-stdin-and-stdout-1/problem?isFullScreen=true

import java.util.Scanner;

public class Solution_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        // String d = scan.next();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        // System.out.println("last:" + d + ":end");
        scan.close();
    }
}