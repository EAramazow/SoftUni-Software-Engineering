package StreamsFilesAndDirectories.Lab;

import org.w3c.dom.ls.LSOutput;

import java.io.*;

public class P03CopyBytes {
    public static void main(String[] args) throws IOException {


        String path = "input.txt";


        FileInputStream inputStream = new FileInputStream(path);

        FileOutputStream outputStream = new FileOutputStream("out-as-bytes.txt");

        PrintStream out = new PrintStream(outputStream);

        int value = inputStream.read();

        while (value != -1) {

            if (value != 10 && value != 32) {
                out.print(value);

            } else {
                out.print((char) value);
            }

            value = inputStream.read();
        }

        inputStream.close();
        outputStream.close();

    }


}
