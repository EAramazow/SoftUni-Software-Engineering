package StreamsFilesAndDirectories.Lab;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Deque;

public class DFSAlgorithm {
    public static void main(String[] args) {


        Path path = Paths.get("C:\\Emil Aramazov\\SoftUni\\Programming Java Advanced - September 2021\\" +
                "Java Advanced" +
                "\\9. Streams, Files and Directories\\Lab\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources");

        // THIS IS ALGORITHM WITH RECURSION

        File root = path.toFile();

        dfs(root);

    }

    private static void dfs(File file) {

        System.out.println(file.getName());

        File[] files = file.listFiles();

        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    dfs(f);
                } else {
                    System.out.println(f.getName());
                }
            }
        }
    }
}
