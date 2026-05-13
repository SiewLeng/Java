// https://www.hackerrank.com/contests/software-engineer-prep-kit/challenges/max-unique-substring-length-in-session/problem?isFullScreen=true

import java.io.*;
import java.util.*;



class Result {

    /*
     * Complete the 'maxDistinctSubstringLengthInSessions' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING sessionString as parameter.
     */

    public static int maxDistinctSubstringLengthInSessions(String sessionString) {
        // Write your code here
        if (sessionString.compareTo("*") == 0 || 
            sessionString.compareTo("") == 0) return 0; 
        int max = 0;
        for (int start = 0; start < sessionString.length(); start++) {
            HashMap<Character, Character> map = new HashMap<>();
            System.out.println("start: " + start);
            for (int i = start; i < sessionString.length(); i++) {
                Character c = sessionString.charAt(i);
                if (!map.containsKey(sessionString.charAt(i))) {
                    map.put(c, c);
                } else {
                    System.out.println("1 i: " + i);
                    break;
                }
            }
            if (map.size() > max) max = map.size();
            System.out.println("i: " + sessionString.length());
        }
        return max;
    }
}

public class Solution_27 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String sessionString = bufferedReader.readLine();

        // System.out.println("sessionString: " + sessionString);

        int result = Result.maxDistinctSubstringLengthInSessions(sessionString);

        System.out.println(result);

        bufferedReader.close();
    }
}
