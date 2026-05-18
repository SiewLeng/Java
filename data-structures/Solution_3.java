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
        int max = 0;
        int m = 6; // size of the array height and width
        int endIndex = m - 3;
        for (int i = 0; i <= endIndex; i++) {
            for (int j = 0; j <= endIndex; j++) {
                int sum = 0;
                for (int col = j; col < j + 3; col++) {
                    sum += arr.get(i).get(col);
                    sum += arr.get(i+2).get(col);
                }
                sum += arr.get(i+1).get(j+1);
                if (i == 0 && j == 0) {
                    max = sum;
                } else {
                    if (sum > max) max = sum;
                }
            }
        }
        System.out.println(max);
        bufferedReader.close();
    }
}
