// https://www.hackerrank.com/challenges/java-1d-array-introduction/problem?isFullScreen=true

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class Solution_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());
            arr[i] = a.get(0);
        }
         
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
       
        bufferedReader.close();
    }
}
