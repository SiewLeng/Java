// https://www.hackerrank.com/challenges/java-currency-formatter/problem?isFullScreen=true

import java.text.*;
import java.util.*;

public class Solution_13 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        
        // Write your code here.
        Locale[] locales = {Locale.US, Locale.of("en", "IN"), Locale.CHINA, Locale.FRANCE};
        NumberFormat[] numberFormats = new NumberFormat[4];
        for (int i = 0; i < locales.length; i++) {
            numberFormats[i] = NumberFormat.getCurrencyInstance(locales[i]);
            numberFormats[i].setMaximumFractionDigits(2);
            numberFormats[i].setMinimumFractionDigits(2);
        }
        
        String us = numberFormats[0].format(payment);
        String india = numberFormats[1].format(payment);
        String china =  numberFormats[2].format(payment);
        String france = numberFormats[3].format(payment);
        
        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}