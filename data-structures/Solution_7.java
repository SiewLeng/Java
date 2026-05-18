// https://www.hackerrank.com/challenges/phone-book/problem?isFullScreen=true

import java.util.*;

public class Solution_7 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<String, String> phoneBook = new HashMap<>();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            String phoneNumber = sc.nextLine();
            phoneBook.put(name, phoneNumber);
        }
        while (sc.hasNext()) {
            String name = sc.nextLine();
            if (phoneBook.containsKey(name)) {
                String out = "";
                out = out + name + "=" + phoneBook.get(name);
                System.out.println(out);
            } else {
                System.out.println("Not found");
            }
        }
        sc.close();
    }
}