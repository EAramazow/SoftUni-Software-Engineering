package FinalExam140821;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProblemTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        //judge 90/100


        String regex = "[*@](?<tag>[A-Z][a-z]{2,})[*@]: \\[(?<string1>[A-Za-z]])\\|\\[(?<string2>[A-Za-z]])\\|\\[(?<string3>[A-Za-z])\\]\\|$";
        Pattern pattern = Pattern.compile(regex);

        int counts = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < counts; i++) {
            String input = scanner.nextLine();


            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String tag = matcher.group("tag");
                String number1 = matcher.group("string1");
                String number2 = matcher.group("string2");
                String number3 = matcher.group("string3");

                System.out.printf("%s: %s %s %s\n", tag, (int) number1.charAt(0), (int) number2.charAt(0), (int) number3.charAt(0));

            } else {

                System.out.println("Valid message not found!");
            }
        }
    }

}