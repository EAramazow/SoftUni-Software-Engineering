package StreamsFilesAndDirectories.Lab;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class P08NestedFolders {
    public static void main(String[] args) {

        String path = "C:\\Emil Aramazov\\SoftUni\\Programming Java Advanced - September 2021\\" +
                "Java Advanced\\9. Streams, Files and Directories\\Lab\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";

        File file = new File(path);

        Deque<File> directories = new ArrayDeque<>();

        directories.offer(file);

        int count = 0;

        while (!directories.isEmpty()) {
            File current = directories.poll();
            File[] nestedFiles = current.listFiles();

            for (File f : nestedFiles)
                if (f.isDirectory())
                    directories.offer(f);
            count++;
            System.out.println(current.getName());
        }
                System.out.println(count + " folders");
            }

        }
