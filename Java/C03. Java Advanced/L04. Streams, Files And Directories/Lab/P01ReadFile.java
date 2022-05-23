package StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class P01ReadFile {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String path = "C:\\Emil Aramazov\\SoftUni\\Programming Java Advanced - September 2021\\Java Advanced" +
                "\\9. Streams, Files and Directories\\Lab\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        int value = inputStream.read();

        while (value != -1) {
            System.out.print(Integer.toBinaryString(value) + " ");
            value = inputStream.read();
        }
    }
}