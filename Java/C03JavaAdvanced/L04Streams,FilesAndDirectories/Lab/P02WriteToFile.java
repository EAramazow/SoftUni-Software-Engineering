package StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.Set;

public class P02WriteToFile {
    public static void main(String[] args) throws IOException {


        String path = "C:\\Emil Aramazov\\SoftUni\\Programming Java Advanced - September 2021\\Java Advanced" +
                "\\9. Streams, Files and Directories\\Lab\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        FileOutputStream outputStream = new FileOutputStream("out.txt");

        Set<Character> punctuations = Set.of(',', '.', '!', '?');


        int value = inputStream.read();

        while (value != -1) {

            char current = (char) value;
            if (!punctuations.contains(current)) {
                outputStream.write(current);

            }


            value = inputStream.read();
        }

        outputStream.close();

    }
}
