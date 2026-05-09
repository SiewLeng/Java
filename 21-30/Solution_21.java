// https://www.hackerrank.com/challenges/java-regex/problem?isFullScreen=true

import java.util.Scanner;

class Solution_21 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }

    }
}

//Write your code here
class MyRegex {
    public String pattern;

    public MyRegex() {
        // 000-255 pattern = (0{0,2}\\d|0{0,1}[1-9]\\d|1(\\d){2}|2[0-4]\\d|25[0-5])
        this.pattern = "(0{0,2}\\d|0{0,1}[1-9]\\d|1(\\d){2}|2[0-4]\\d|25[0-5])(\\.(0{0,2}\\d|0{0,1}[1-9]\\d|1(\\d){2}|2[0-4]\\d|25[0-5])){3}$";
    }
}