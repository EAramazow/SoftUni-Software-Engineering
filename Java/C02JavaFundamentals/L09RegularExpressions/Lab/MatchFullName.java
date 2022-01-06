package regularExpressions.Lab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFullName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String textInput = scanner.nextLine();

        String regex = "(?<firstName>\\b[A-Z][a-z]+) (?<lastName>[A-Z][a-z]+\\b)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(textInput);

        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }
    }
}
