package P04ListUtilities;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> integers = List.of(1, 2, 3, 4);
        List<String> strings = List.of("1", "2", "3", "4");

        System.out.println(ListUtilities.getMin(integers));
        System.out.println(ListUtilities.getMax(strings));
    }
}
