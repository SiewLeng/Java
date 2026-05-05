// https://www.hackerrank.com/challenges/java-loops-i/problem?isFullScreen=true

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1 {
     public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        bufferedReader.close();

        int numOfLoops = 10;
        for (int i = 1;  i <= numOfLoops; i++) {
            int result = N * i;
            System.out.println(N + " x " + i + " = " + result);
        }
  
    }
}
