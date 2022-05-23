package StreamsFilesAndDirectories.Lab;

import java.io.*;
import java.util.Scanner;

public class P04ExtractIntegers {
    public static void main(String[] args) throws IOException {

        String path = "input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        FileOutputStream outputStream = new FileOutputStream("extract-integers.txt");

        PrintStream out = new PrintStream(outputStream);


        Scanner scanner = new Scanner(inputStream);

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int numbers = scanner.nextInt();
                out.println(numbers);
            }
            scanner.next();


        }


        inputStream.close();
        outputStream.close();

    }
}
