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

    static  ArrayList<ArrayList<Integer>> getEmptySpaces(List<String> crossword) {
        ArrayList<ArrayList<Integer>> empty = new ArrayList<>();
        for (int i = 0; i < crossword.size(); i++) {
            String row  = crossword.get(i);
            int start = identifyEmptySpace(row)[0];
            int end = identifyEmptySpace(row)[1];
            if (start!= -1 && end!= -1) {
                ArrayList<Integer> result = new ArrayList<>(List.of(i, start, end, 0));
                empty.add(result);
            }
        }
        for (int j = 0; j < crossword.size(); j++) {
            String col = "";
            for (int i = 0; i < crossword.size(); i++) {
                col = col + crossword.get(i).charAt(j);
            }
            int start = identifyEmptySpace(col)[0];
            int end = identifyEmptySpace(col)[1];
            if (start != -1 && end != -1) {
                ArrayList<Integer> result = new ArrayList<>(List.of(j, start, end, 1));
                empty.add(result);
            }
        }
        return empty;
    } 

    static boolean isValidFill(char[][] crossword, String word, ArrayList<Integer> toBeFilled) {
        int start = toBeFilled.get(1);
        int end = toBeFilled.get(2);
        if ((end - start + 1) != word.length()) return false; 
        if (toBeFilled.get(3) == 0) {
            // horizontal
            int rowIndex = toBeFilled.get(0);
            for (int j = 0; j < word.length(); j++) {
                char c = crossword[rowIndex][j + start];
                if (c != '-' && word.charAt(j) != c) return false;
            }
        } else {
            // vertical
            int colIndex = toBeFilled.get(0);
            for (int i = 0; i < word.length(); i++) {
                char c = crossword[i + start][colIndex];
                if (c != '-' && word.charAt(i) != c) return false;
            }
        }
        return true;
    }

    static void fillCrossWord(char[][] crossword, String word, ArrayList<Integer> toBeFilled) {
        int start = toBeFilled.get(1);
        if (toBeFilled.get(3) == 0) {
            // horizontal
            int rowIndex = toBeFilled.get(0);
            for (int j = 0; j < word.length(); j++) {
                char c = crossword[rowIndex][j + start];
                if (c == '-') crossword[rowIndex][j + start] = word.charAt(j);
            }
        } else {
            // vertical
            int colIndex = toBeFilled.get(0);
            for (int i = 0; i < word.length(); i++) {
                char c = crossword[i + start][colIndex];
                if (c == '-') crossword[i + start][colIndex] = word.charAt(i);
            }
        }
    }

    static void unfillCrossWord(char[][] crossword, String word, ArrayList<Integer> toBeUnFilled) {
        int start = toBeUnFilled.get(1);
        if (toBeUnFilled.get(3) == 0) {
            // horizontal
            int rowIndex = toBeUnFilled.get(0);
            for (int j = 0; j < word.length(); j++) {
                char c = crossword[rowIndex][j + start];
                if (c != '-') crossword[rowIndex][j + start] = '-';
            }
        } else {
            // vertical
            int colIndex = toBeUnFilled.get(0);
            for (int i = 0; i < word.length(); i++) {
                char c = crossword[i + start][colIndex];
                if (c != '-') crossword[i + start][colIndex] = '-';
            }
        }
    }

    static char[][] convertListOfStringToDoubleArrayChar(List<String> crossword) {
        char[][] crosswordPuzzle = new char[crossword.size()][crossword.size()];
        for (int i = 0; i < crossword.size(); i++) {
            for (int j = 0; j < crossword.get(i).length(); j++) {
                crosswordPuzzle[i][j] = crossword.get(i).charAt(j);
            }
        }
        return crosswordPuzzle;
    }

    static List<String> convertDoubleArrayCharToListOfString(char[][] crosswordPuzzle) {
        List<String> crossword = new ArrayList<>();
        for (char[] row : crosswordPuzzle) {
            String s = "";
            for (int j = 0; j < row.length; j++) {
                s = s + row[j];
            }
            crossword.add(s);
        }
        return crossword;
    }

    static boolean recursiveFill(char[][] crossword, List<String> wordList, ArrayList<ArrayList<Integer>> emptySpaces, int index) {
        if (index == emptySpaces.size()) return true;
        for (String word: wordList) {
            if(isValidFill(crossword, word, emptySpaces.get(index))) {
                fillCrossWord(crossword, word, emptySpaces.get(index));
                List<String> newWordList = new ArrayList<>();
                for (String newword: wordList) {
                    if (newword.compareTo(word) != 0) newWordList.add(newword);
                }
                if (recursiveFill(crossword, newWordList, emptySpaces, index + 1)) {
                    return true;
                }
                unfillCrossWord(crossword, word, emptySpaces.get(index));
            }
        }
        return false;
    }

    public static List<String> crosswordPuzzle(List<String> crossword, String words) {
        // Write your code here
        ArrayList<ArrayList<Integer>> emptySpaces = getEmptySpaces(crossword);
        List<String> wordList = Arrays.asList(words.split(";"));
        char[][] crosswordDoubleArrayOfChar = convertListOfStringToDoubleArrayChar(crossword);
        recursiveFill(crosswordDoubleArrayOfChar, wordList, emptySpaces, 0);
        crossword = convertDoubleArrayCharToListOfString(crosswordDoubleArrayOfChar);
        for (String row : crossword) {
            System.out.println(row);
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


