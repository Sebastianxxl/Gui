package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args) {
        String regex = "(0[237]\\d{2})\\d{6}";
        String text = "Numerele mele sunt 0741989790, 0722871581, 0756226232, 0744697542";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            System.out.println(matcher.group(1));
        }


        //System.out.println(text.replaceAll(regex, "\\1*"));
    }
}
