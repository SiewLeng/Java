// https://www.hackerrank.com/challenges/java-output-formatting/problem?isFullScreen=true

import java.util.Scanner;

public class Solution_5 {
     public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            String [] arr = new String[3];
            for(int i=0;i<3;i++){
                String s1=sc.next();
                int x=sc.nextInt();
                String s = String.format("%-15s", s1);
                s += String.format("%03d", x);
                arr[i] = s;
            }
            System.out.println("================================");
            for(String s : arr){
                System.out.println(s);
            }
            System.out.println("================================");
            sc.close();
    }  
}
