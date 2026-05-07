import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Long low = scan.nextLong();
        Long high = scan.nextLong();

        Double end_3 = (Math.log(high) / Math.log(3));
        Double end_5 = (Math.log(high) / Math.log(5));

        System.out.println("end_3: " + end_3);
        System.out.println("end_5: " + end_5);
        
        int count = 0;
        for (int x = 0; x <= end_3; x++) {
            for (int y = 0; y <= end_5; y++) {
                Double ans = Math.pow(3, x) * Math.pow(5, y);
                if (ans >= low && ans <= high) {
                    System.out.println("x:" + x + " y:" + y + " ans:" + ans);
                    count++;
                }
            }
        }
        System.out.println("count: " + count);
    }
}