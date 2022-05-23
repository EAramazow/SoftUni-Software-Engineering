package StreamsFilesAndDirectories.Exercise;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class P01SumLines {
    public static void main(String[] args) throws IOException {

        String inputDir = "C:\\Emil Aramazov\\SoftUni\\Programming Java Advanced - September 2021" +
                "\\Java Advanced\\9. Streams, Files and Directories\\Exercise" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        Path path = Path.of(inputDir);

        List<String> allLines = Files.readAllLines(path);




         //way 1

        allLines.stream().map(String::toCharArray).forEach(
                charArray -> {
                int sum = 0;
                    for (char c : charArray) {
                        sum += c;
                    }
                    System.out.println(sum);
        });




        // way 2
//        for (String line : allLines) {
//            int sum = 0;
//            for (int i = 0; i < line.length(); i++) {
//                char currentSymbol = line.charAt(i);
//                sum += currentSymbol;
//            }
//            System.out.println(sum);
//        }


    }
}
