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
    private static int checkMaxDistinctSubstringLengthinCharacterString(String s) {
         int max = 1;
        int l = 0;
        int r = 0;
        Set <Character> set = new HashSet<>();
        set.add(s.charAt(l));
        while (r < s.length() - 1) {
            if (!set.contains(s.charAt(r + 1))) {
                set.add(s.charAt(r + 1));
                r += 1;
            } else {
                set.remove(s.charAt(l));
                l += 1;
            }
            int len = r - l + 1;
            if (len > max) max = len;
        }
        return max;
    }

    public static int maxDistinctSubstringLengthInSessions(String sessionString) {
        // Write your code here
        String[] tokens = sessionString.split("\\*");
        int max = 0;
        for (String token:tokens) {
            if (token.length() > 0) {
                int maxSubLength = checkMaxDistinctSubstringLengthinCharacterString(token);
                if (maxSubLength > max) max = maxSubLength;
            }
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
