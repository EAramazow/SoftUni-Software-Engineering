package objectsAndClasses.Exercise.P02Articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] inputData = input.split(",\\s+");
        String title = inputData[0];
        String content = inputData[1];
        String author = inputData[2];

        Articles article = new Articles(title, content, author);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();
            String commandName = command.split(": ")[0];
            String commandParameter = command.split(": ")[1];

            switch (commandName) {
                case "Edit":
                    article.edit(commandParameter);
                    break;

                case "ChangeAuthor":
                    article.changeAuthor(commandParameter);
                    break;

                case "Rename":
                    article.rename(commandParameter);
                    break;
            }

        }

        System.out.println(article.toString());
    }
}
