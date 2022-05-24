package objectsAndClasses.Lab;

import java.util.Random;
import java.util.Scanner;

public class P01RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] sentence = scanner.nextLine().split(" ");

        Random random = new Random();

        for (int i = 0; i < sentence.length; i++) {
            // разменямае два елемента
            int randomIndex = random.nextInt(sentence.length);
            String temp = sentence[i];
            sentence[i] = sentence[randomIndex];
            sentence[randomIndex] = temp;

        }

        for (String word : sentence) {
            System.out.println(word);
        }
    }
}
