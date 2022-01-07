package StreamsFilesAndDirectories.Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P05LineNumber {
    public static void main(String[] args) throws IOException {


        String inputDir = "C:\\Emil Aramazov\\SoftUni\\Programming Java Advanced - September 2021" +
                "\\Java Advanced\\9. Streams, Files and Directories\\Exercise" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";


//        BufferedReader reader = new BufferedReader(new FileReader(inputDir));
//        PrintWriter writer = new PrintWriter("outputlinenumber.txt");
//        String line = reader.readLine();
//        int count = 1;
//        while (line != null) {
//            writer.println(count + ". " + line);
//            line = reader.readLine();
//        }
//
//        reader.close();


        List<String> allLines = Files.readAllLines(Path.of(inputDir));

        PrintWriter writer = new PrintWriter("line-numbers.txt");

        int countLines = 1;
        for (String line : allLines) {
            writer.println(countLines++ + ". " + line);
        }

        writer.close();

    }
}
