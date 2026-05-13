// https://www.hackerrank.com/challenges/tag-content-extractor/problem?isFullScreen=true

import java.util.*;
import java.util.regex.*;

public class Solution_23 {
    public static void main(String[] args){
        
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            String line = in.nextLine();
            boolean isMatch = false;
            String stringPattern = "<(.+)>([^<>]+)</\\1>";
            Pattern pattern = Pattern.compile(stringPattern);
            Matcher matcher = pattern.matcher(line);
            
            while(matcher.find()) {
                System.out.println(matcher.group(2));
                isMatch = true;
            }
            if (!isMatch) {
                System.out.println("None");
            }
            
            testCases--;
        }
    }
}







