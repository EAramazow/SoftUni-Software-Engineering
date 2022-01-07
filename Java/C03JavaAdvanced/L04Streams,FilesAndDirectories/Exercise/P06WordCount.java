package StreamsFilesAndDirectories.Exercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class P06WordCount {
    public static void main(String[] args) throws IOException {
        String inputDir = "C:\\Emil Aramazov\\SoftUni" +
                "\\Programming Java Advanced - September 2021\\Java Advanced" +
                "\\9. Streams, Files and Directories\\Exercise" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\words.txt";

        Path path = Path.of(inputDir);

        List<String> allLinesWords = Files.readAllLines(path);

        LinkedHashMap<String, Integer> wordsCount = new LinkedHashMap<>();

        allLinesWords.forEach(line -> Arrays.stream(line.split("\\s+"))
                .forEach(word -> wordsCount.put(word, 0)));

        Path pathText = Path.of("C:\\Emil Aramazov\\SoftUni" +
                "\\Programming Java Advanced - September 2021\\Java Advanced\\9. Streams, Files and Directories" +
                "\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\Exercises Resources\\text.txt");

        List<String> textAllLines = Files.readAllLines(pathText);

        for (String line : textAllLines) {
            String[] wordsInLine = line.split("\\s+");
            Arrays.stream(wordsInLine).forEach(word -> {

                if (word.contains(",")) {
                    word = word.replaceAll(",", "");
                }

                if (wordsCount.containsKey(word)) {
                    int currentCount = wordsCount.get(word);
                    wordsCount.put(word, currentCount + 1);


                }
            });
        }
        wordsCount.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        PrintWriter writer = new PrintWriter("word-count.txt");

        wordsCount.entrySet().forEach(entry -> writer.println(entry.getKey() + " - " + entry.getValue()));
        writer.close();
    }
}
