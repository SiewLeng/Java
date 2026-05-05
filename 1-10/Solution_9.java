import java.util.Scanner;

public class Solution_4 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int i = 0;
        while(sc.hasNext()) {
            i += 1;
            System.out.println(i + " " + sc.nextLine());
        }
        sc.close();
    }  
}