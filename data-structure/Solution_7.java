// https://www.hackerrank.com/challenges/crossword-puzzle/problem?isFullScreen=true

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    /*
     * Complete the 'crosswordPuzzle' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY crossword
     *  2. STRING words
     */
 static int[] identifyEmptySpace(String row) {
        int start = -1;
        int end = -1;
        for (int i = 0; i < row.length(); i++) {
            if (start == -1 && row.charAt(i) == '-') start = i;
            if (start != -1 && end == -1 && (row.charAt(i) == '+')) end = i - 1;
            if (start != -1 && end == -1 && (row.charAt(i) == '-') && i ==  row.length() - 1) end = i;
            if (start == end) {
                start = -1;
                end = -1;
            }
        }
        int[] result = {start, end};
        return result;
    }

    public static List<String> crosswordPuzzle(List<String> crossword, String words) {
    // Write your code here
        ArrayList<ArrayList<Integer>> empty = new ArrayList<>();
        for (int i = 0; i < crossword.size(); i++) {
            String row  = crossword.get(i);
            if (identifyEmptySpace(row)[0] != -1 && identifyEmptySpace(row)[1] != -1) {
                ArrayList<Integer> result = new ArrayList<>(List.of(i, identifyEmptySpace(row)[0], identifyEmptySpace(row)[1], 0));
                empty.add(result);
            }
        }
        for (int j = 0; j < crossword.size(); j++) {
            String col = "";
            for (int i = 0; i < crossword.size(); i++) {
                col = col + crossword.get(i).charAt(j);
            }
            System.out.println("col: " + col);
            if (identifyEmptySpace(col)[0] != -1 && identifyEmptySpace(col)[1] != -1) {
                ArrayList<Integer> result = new ArrayList<>(List.of(j, identifyEmptySpace(col)[0], identifyEmptySpace(col)[1], 1));
                empty.add(result);
                System.out.println(j + " " + identifyEmptySpace(col)[0] + " " +identifyEmptySpace(col)[1]);
            }
        }
        return crossword;
    }
}

public class Solution_7 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test.txt"));

        List<String> crossword = IntStream.range(0, 10).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        String words = bufferedReader.readLine();

        List<String> result = Result.crosswordPuzzle(crossword, words);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}


