package methods.Lab;

import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        int rotation = Integer.parseInt(scanner.nextLine());
        String repeatedString = repeatString(text, rotation);
        System.out.println(repeatedString);
    }

    private static String repeatString(String text, int rotation) {
        String result = "";
        for (int i = 0; i < rotation; i++) {
            result += text;
            
        }
        return result;
    }
}
