import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args){
        Pattern pattern = Pattern.compile("\\d+"); // Matches digits
        Matcher matcher = pattern.matcher("There are 2 cats and 15 dogs.");
        
        while (matcher.find()) {
            System.out.println("Found: " + matcher.group());
        }
        
        /* 
        if (matcher.find()) {
            System.out.println("Found: " + matcher.group());
        }
        */
    }
}
