// https://www.hackerrank.com/challenges/java-bitset/problem?isFullScreen=true

import java.util.*;

public class Solution_14 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // size of bits
        int m = sc.nextInt(); // number of testcases
        sc.nextLine();
        
        BitSet b1 = new BitSet(n);
        BitSet b2 = new BitSet(n);
        for (int i = 0; i < m; i++) {
            String[] tokens = sc.nextLine().split(" ");
            String operation = tokens[0];
            if (operation.compareTo("AND") == 0) {
                if (tokens[1].compareTo("1") == 0 && 
                    tokens[2].compareTo("2") == 0) {
                    b1.and(b2);
                } else if (tokens[1].compareTo("2") == 0 && 
                    tokens[2].compareTo("1") == 0) {
                    b2.and(b1);
                }
            } else if (operation.compareTo("OR") == 0) {
                 if (tokens[1].compareTo("1") == 0 && 
                    tokens[2].compareTo("2") == 0) {
                    b1.or(b2);
                } else if (tokens[1].compareTo("2") == 0 && 
                    tokens[2].compareTo("1") == 0) {
                    b2.or(b1);
                }
            } else if (operation.compareTo("XOR") == 0) {
                if (tokens[1].compareTo("1") == 0 && 
                    tokens[2].compareTo("2") == 0) {
                    b1.xor(b2);
                } else if (tokens[1].compareTo("2") == 0 && 
                    tokens[2].compareTo("1") == 0) {
                    b2.xor(b1);
                }
            } else if (operation.compareTo("SET") == 0) {
                int index = Integer.parseInt(tokens[2]);
                if (tokens[1].compareTo("1") == 0) {
                    b1.set(index);
                } else if (tokens[1].compareTo("2") == 0) {
                    b2.set(index);
                }
            } else if (operation.compareTo("FLIP") == 0)  {
                int index = Integer.parseInt(tokens[2]);
                if (tokens[1].compareTo("1") == 0) {
                    b1.flip(index);
                } else if (tokens[1].compareTo("2") == 0) {
                    b2.flip(index);
                }
            }
            String output = b1.cardinality() + " " + b2.cardinality();
            System.out.println(output);
        }
        sc.close();
    }
}