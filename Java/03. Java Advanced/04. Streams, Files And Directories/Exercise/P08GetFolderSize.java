package StreamsFilesAndDirectories.Exercise;

import java.io.File;

public class P08GetFolderSize {
    public static void main(String[] args) {

        String inputDir = "C:\\Emil Aramazov\\SoftUni\\Programming Java Advanced - September 2021" +
                "\\Java Advanced\\9. Streams, Files and Directories\\Exercise" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        File folder = new File(inputDir);

        File[] filesInFolder = folder.listFiles();

        int folderSize = 0;
        for (File file : filesInFolder) {
            folderSize += file.length();
        }

        System.out.println("Folder size: " + folderSize);
    }
}
