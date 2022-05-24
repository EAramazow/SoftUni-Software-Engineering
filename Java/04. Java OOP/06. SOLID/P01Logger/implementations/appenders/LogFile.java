package L06SOLID.Exercise.P01Logger.implementations.appenders;

import L06SOLID.Exercise.P01Logger.interfaces.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class LogFile implements File {
    private static final String DEFAULT_FINAL_NAME = "default.txt";

    private StringBuilder text;
    private int size;
    private String fileName;

    public LogFile() {
     this(DEFAULT_FINAL_NAME);
    }

    public LogFile(String fileName) {
        this.text = new StringBuilder();
        this.size = 0;
        this.fileName = fileName;
    }

    @Override
    public int getSize() {
        return this.calculateSize();
    }

    private int calculateSize() {
        int size = 0;

        for(char c : this.text.toString().toCharArray()) {
            if (Character.isAlphabetic(c)) {
                size += c;
            }
        }

        return size;
    }

    @Override
    public boolean write(String text) {
        try {
            Files.write(Paths.get(this.fileName), text.getBytes(), StandardOpenOption.APPEND);

            // StandardOpenOption - append-ва информация (добавя), А НЕ ПРЕЗАПИСВА!

            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void append(String text) {
        text = addLineBreakInFile(text);
        this.text.append(text);
        this.write(text);
    }

    private String addLineBreakInFile(String text){
        StringBuilder stringBuilder = new StringBuilder(text);
        stringBuilder.append(System.lineSeparator());
        return stringBuilder.toString();
    }
}
