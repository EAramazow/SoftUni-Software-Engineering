package StreamsFilesAndDirectories.Exercise;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class P02SumBytes {
    public static void main(String[] args) throws IOException {

        String inputDir = "C:\\Emil Aramazov\\SoftUni\\Programming Java Advanced - September 2021" +
                "\\Java Advanced\\9. Streams, Files and Directories\\Exercise" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        byte[] allBytes = Files.readAllBytes(Path.of(inputDir));

        long sum = 0;
        for (byte allByte : allBytes) {
            if (allByte != 10 && allByte != 13) {
                sum += allByte;

            }
        }
        System.out.println(sum);

    }
}
