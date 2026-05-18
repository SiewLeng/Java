// https://www.hackerrank.com/challenges/java-2d-array/problem?isFullScreen=true

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;



public class Solution_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        int startRow = 0;
        int n = 3; // size of the subArray height and width
        int max = Integer.MIN_VALUE;
        int m = 6; // size of the array height and width
        while (startRow < m) {
            int subArraySum = 0;
            for (int i = startRow; i < startRow + n; i++) {
                for (int j = 0; j < n; j++) {
                    subArraySum += arr.get(i).get(j);
                }
            }
            if (subArraySum > max) {
                max = subArraySum;
            }
            for (int j = n; j < m; j++) {
                for (int i = startRow; i < startRow + n; i++) {
                    subArraySum += arr.get(i).get(j) -  arr.get(i).get(j - n);
                }
                if (subArraySum > max) {
                    max = subArraySum;
                }
            }
            startRow += n;
        }
        System.out.println(max);

        bufferedReader.close();
    }
}
