// https://www.hackerrank.com/challenges/java-stack/problem?isFullScreen=true

import java.util.*;

public class Solution_8 {
    public static boolean isBalancedString(String s) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '{' || c == '(' || c == '[') {
                stack.add((Character) c);
            } else if (c == '}') {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.add((Character) c);
                }
            } else if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }  else {
                    stack.add((Character) c);
                }
            } else if (c == ']') {
                 if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                }  else {
                    stack.add((Character) c);
                }
            }
            i++;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            boolean isBalanced = isBalancedString(s);
            System.out.println(isBalanced? "true": "false" );
        }
    }
}
