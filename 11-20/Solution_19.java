import java.util.Scanner;

public class Solution_19 {

    static int[] countAlphabets(String a) {
        a = a.toLowerCase();
        int a_index = (int) 'a';
        int z_index = (int) 'z';
        int n = z_index - a_index + 1;
        int[] counts = new int[n];
        for (int i = 0; i < n; i++) {
            counts[i] = 0;
        }
        for (int i = 0; i < a.length(); i++) {
            counts[(int)a.charAt(i) - a_index] += 1;
        }
        return counts;
    }

    static boolean isAnagram(String a, String b) {
        // Complete the function
        int[] count_a = countAlphabets(a);
        int[] count_b = countAlphabets(b);
        for (int i = 0; i < count_a.length; i++) {
            if (count_a[i] != count_b[i]) {
                return false;
            } 
        }
        return true;
    }

    public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}