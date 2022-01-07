package StreamsFilesAndDirectories.Lab;

import java.io.File;
import java.io.IOException;


public class P07ListFiles {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Emil Aramazov\\SoftUni\\Programming Java Advanced - September 2021\\" +
                "Java Advanced\\9. Streams, Files and Directories\\Lab\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";

        File file = new File(path);

        File[] filesArr = file.listFiles();

        for (File f : filesArr) {
            if (!f.isDirectory()) {
                System.out.printf("%s: [%d]\n", f.getName(), f.length());
            }
        }
    }
}
