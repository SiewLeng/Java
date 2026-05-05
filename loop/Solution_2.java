import java.util.Scanner;

class Solution_2 {
    private static String combined(int[] arr) {
        String s = "";
        for (int i = 0; i < arr.length - 1; i++) {
            s += arr[i] + " ";
        }
        s += arr[arr.length - 1];
        return s;
    }

    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        int[][] queries = new int[t][3];
        for(int i = 0;i < t; i++){
            queries[i][0] = in.nextInt();
            queries[i][1] = in.nextInt();
            queries[i][2] = in.nextInt();
        }
        in.close();
        for (int i = 0; i <= t - 1; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            int n = queries[i][2];
            int[] result = new int[n];
            for (int j = 0; j <= n - 1; j++) {
                if (j == 0) {
                    result[j] = a + 1 * b;
                } else {
                    result[j] = result[j - 1] + (int)Math.pow(2, j) * b;
                }
            }
            System.out.println(combined(result));
        }
    }
}