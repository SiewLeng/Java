// https://www.hackerrank.com/challenges/java-if-else/problem?isFullScreen=true

import java.util.Scanner;

public class Solution_3 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        if (N%2 == 1) {
            System.out.println("Weird");
        } else if (N>= 2 && N<= 4) {
            System.out.println("Not Weird");
        } else if (N>= 6 && N<= 20) {
            System.out.println("Weird");
        } else if (N>= 22) {
            System.out.println("Not Weird");
        }
        scanner.close();
    }

}
