package StreamsFilesAndDirectories.Exercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P07MergeTwoFiles {
    public static void main(String[] args) throws IOException {

        String firstDir = "C:\\Emil Aramazov\\SoftUni\\Programming Java Advanced - September 2021" +
                "\\Java Advanced\\9. Streams, Files and Directories\\Exercise" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\inputOne.txt";

        String secondDir = "C:\\Emil Aramazov\\SoftUni\\Programming Java Advanced - September 2021" +
                "\\Java Advanced\\9. Streams, Files and Directories\\Exercise" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\inputTwo.txt";

        Path firstPath = Path.of(firstDir);
        Path secondPath = Path.of(secondDir);

        List<String> allLinesFirstFile = Files.readAllLines(firstPath);
        List<String> allLinesSecondFile = Files.readAllLines(secondPath);

        PrintWriter writer = new PrintWriter("merge-two-files.txt");

        allLinesFirstFile.forEach(line -> writer.println(line));
        allLinesSecondFile.forEach(line -> writer.println(line));

        writer.close();

    }
}
