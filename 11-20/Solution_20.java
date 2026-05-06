// https://www.hackerrank.com/challenges/java-string-tokens/problem?isFullScreen=true

import java.util.Scanner;

public class Solution_20 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
        scan.close();
        String regex = "[ !,?._'@]+";
        String[] tokens = s.split(regex);
        if (tokens.length == 0) {
            System.out.println(tokens.length);
        } else {
            boolean emptyFirst = tokens[0].compareTo("") == 0;
            System.out.println((emptyFirst) ? tokens.length - 1: tokens.length);
            if (emptyFirst == false) System.out.println(tokens[0]);
            for (int i = 1; i < tokens.length; i++) {
                System.out.println(tokens[i]);
            }
        } 
    }
}