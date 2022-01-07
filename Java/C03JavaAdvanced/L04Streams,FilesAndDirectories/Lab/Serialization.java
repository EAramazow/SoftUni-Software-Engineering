package StreamsFilesAndDirectories.Lab;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // SERIALIZATION

        List<Integer> numbers = new ArrayList<>();

        numbers.add(13);
        numbers.add(42);
        numbers.add(69);
        numbers.add(73);


        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("serialization-out.txt"));

        outputStream.writeObject(numbers);

        // DESERIALIZATION

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("serialization-out.txt"));

        List<Integer> numbers2 = (List<Integer>) inputStream.readObject();

        System.out.println();

    }
}
