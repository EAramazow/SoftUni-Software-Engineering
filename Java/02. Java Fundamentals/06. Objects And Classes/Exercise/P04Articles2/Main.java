package objectsAndClasses.Exercise.P04Articles2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Articles> articlesList = new ArrayList<>();

        for (int i = 0; i <n ; i++) {
            String[] commandData = scanner.nextLine().split(", ");
            String title = commandData[0];
            String content = commandData[1];
            String author = commandData[2];

            Articles article = new Articles(title, content, author);
            articlesList.add(article);
        }



           String lastInput = scanner.nextLine();

        if (lastInput.equals("title")) {
            articlesList.sort(Comparator.comparing(Articles::getTitle));
            System.out.println(articlesList.toString().replaceAll("[\\[\\],]", ""));
        } else if (lastInput.equals("content")) {
            articlesList.sort(Comparator.comparing(Articles::getContent));
            System.out.println(articlesList.toString().replaceAll("[\\[\\],]", ""));
        } else if (lastInput.equals("author")) {
            articlesList.sort(Comparator.comparing(Articles::getAuthor));
            System.out.println(articlesList.toString().replaceAll("[\\[\\],]", ""));
        }
    }
}
