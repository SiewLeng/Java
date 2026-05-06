// https://www.hackerrank.com/challenges/java-int-to-string/problem

import java.util.*;

public class Solution_12 {
    public static void main(String[] args) {

        // DoNotTerminate.forbidExit();

        try {
            Scanner in = new Scanner(System.in);
            int n = in .nextInt();
            in.close();
            // start
            int c = n;
            int r = 0;
            boolean isNegative = c < 10;
            String s = "";
            if (c < 0) {
                c = -c;
            }
            if (c == 0) s = "0";
            while (c >= 1) {
                r = c % 10;
                String[]arr = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
                s = arr[r] + s;
                c = c / 10;
            }
            if (isNegative) s = "-" + s;
            // end
            if (n == Integer.parseInt(s)) {
                System.out.println("Good job");
            } else {
                System.out.println("Wrong answer.");
            }
        } catch (DoNotTerminate.ExitTrappedException e) {
            System.out.println("Unsuccessful Termination!!");
        }
    }
}

//The following class will prevent you from terminating the code using exit(0)!
class DoNotTerminate {
    public static class ExitTrappedException extends SecurityException {
        private static final long serialVersionUID = 1;
    }

    /* 
    public static void forbidExit() {
        final SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission permission) {
                if (permission.getName().contains("exitVM")) {
                    throw new ExitTrappedException();
                }
            }
        };
        System.setSecurityManager(securityManager);
    }
    */
}
