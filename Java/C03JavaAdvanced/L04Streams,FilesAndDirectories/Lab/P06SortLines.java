package StreamsFilesAndDirectories.Lab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class P06SortLines {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("C:\\Emil Aramazov\\SoftUni\\Programming Java Advanced - September 2021\\" +
                "Java Advanced" +
                "\\9. Streams, Files and Directories\\Lab\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");

        List<String> lines = Files.readAllLines(path)
                .stream()
                .sorted()
                .collect(Collectors.toList());

        Files.write(Paths.get("sort-lines.txt"), lines);

    }
}
