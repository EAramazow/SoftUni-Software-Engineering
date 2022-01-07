package FunctionalProgramming.Lab;

import java.util.List;
import java.util.stream.IntStream;

public class Demo {
    public static void main(String[] args) {


        var filter = ""; // variable without a type


        // the best cool thing for stream()

        //if i have function (chain of functions)
        //nothing is executed until I want a result

        List<Integer> numbers = List.of(13, 42, 69, 73);

        IntStream intStream = numbers.stream()
                .mapToInt(Demo::mapper);

        int sum = intStream.sum();
        System.out.println(sum);

        System.out.println("End of program!");
    }

    public static int mapper (Integer number) {
        System.out.println("Mapper called");
        return number;
    }
}
