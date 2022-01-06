package textProcessing.Exercise;

import java.util.Scanner;

public class P03ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String [] directory = input.split("\\\\");

        String[] filesAndExtensions = directory[directory.length - 1].split("\\.");

            String file = filesAndExtensions[0];
            String extension = filesAndExtensions[1];

            System.out.printf("File name: %s\n", file);
            System.out.printf("File extension: %s\n", extension);



    }
}
