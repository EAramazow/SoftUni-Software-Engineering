package StreamsFilesAndDirectories.Exercise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class P04CountCharacterTypes {
    public static void main(String[] args) throws IOException {

        String inputDir = "C:\\Emil Aramazov\\SoftUni\\Programming Java Advanced - September 2021" +
                "\\Java Advanced\\9. Streams, Files and Directories\\Exercise" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        List<String> allLines = Files.readAllLines(Path.of(inputDir));



        AtomicInteger vowelCount = new AtomicInteger();
        AtomicInteger consonantsCount = new AtomicInteger();
        AtomicInteger punctuationCount = new AtomicInteger();


        allLines.forEach(line -> {
            for (int i = 0; i < line.length(); i++) {
                char currentSymbol = line.charAt(i);
                if (currentSymbol == ' ') {
                    continue;
                }
                if (currentSymbol == 'a' || currentSymbol == 'e'
                        || currentSymbol == 'i' || currentSymbol == 'o' || currentSymbol == 'u') {
                    vowelCount.getAndIncrement();
                } else if (currentSymbol == '!' || currentSymbol == ','
                        || currentSymbol == '.' || currentSymbol == '?') {
                    punctuationCount.getAndIncrement();
                } else {
                    consonantsCount.getAndIncrement();
                }
            }

        });


        BufferedWriter writer = new BufferedWriter(new FileWriter("count-char.txt"));
        writer.write("Vowels: " + vowelCount);
        writer.newLine();
        writer.write("Consonants: " + consonantsCount);
        writer.newLine();
        writer.write("Punctuation: " + punctuationCount);

        writer.close();

    }
}

