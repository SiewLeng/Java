// https://www.hackerrank.com/challenges/java-string-tokens/problem?isFullScreen=true

import java.util.*;

public class Solution_6 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
        String regex = "[ !,?._'@]+";
        String[] tokens = s.split(regex);
        if (tokens.length > 0 && tokens[0].compareTo("") == 0) {
            String [] new_tokens = new String[tokens.length - 1];
            for (int i = 0; i < new_tokens.length; i++) {
                new_tokens[i] = tokens[i + 1];
            }
            tokens = new_tokens;
        }
        System.out.println(tokens.length);
        for (String token: tokens) {
            System.out.println(token);
        }
        scan.close();
    }
}

