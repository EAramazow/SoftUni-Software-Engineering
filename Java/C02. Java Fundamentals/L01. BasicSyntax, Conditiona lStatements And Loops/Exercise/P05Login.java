package basicSyntaxConditionalStatementsLoops.Exercise;

import java.util.Scanner;

public class P05Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // имаме username (Emil)
        // паролата е обърнат username (limE)

        String username = scanner.nextLine();
        String password = "";

        for (int position = username.length() - 1; position >= 0; position--) {
            char symbol = username.charAt(position);
            password += symbol;
        }


        String enteredPassword = scanner.nextLine();
        int counter = 0;

        while (!enteredPassword.equals(password)) {

            // ако паролата е грешна - incorrect password! try again

            counter++;

            if (counter >= 4) {
                System.out.printf("User %s blocked!", username);
                return;
            }
            System.out.println("Incorrect password. Try again.");

            enteredPassword = scanner.nextLine();

        }


        System.out.printf("User %s logged in.", username);
    }


}

