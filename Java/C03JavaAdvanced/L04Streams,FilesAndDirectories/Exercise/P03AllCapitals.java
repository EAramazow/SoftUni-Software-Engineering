package StreamsFilesAndDirectories.Exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class P03AllCapitals {
    public static void main(String[] args) throws IOException {

        String inputDir = "C:\\Emil Aramazov\\SoftUni\\Programming Java Advanced - September 2021" +
                "\\Java Advanced\\9. Streams, Files and Directories\\Exercise" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        BufferedWriter writer = new BufferedWriter(new FileWriter("all-capitals.txt"));

        Files.readAllLines(Path.of(inputDir)).forEach(line -> {
            try {
                writer.write(line.toUpperCase());
                writer.newLine();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });

        writer.close();
    }
}
