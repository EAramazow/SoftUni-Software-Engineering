package ExampleIterableAndIterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Shelf implements Iterable<String> {

    private List<String> fruits;

    public Shelf(String... fruits) {
        this.fruits = Arrays.asList(fruits);
    }

    @Override
    public Iterator<String> iterator() {
        return new ShopEmployee();
    }

    class ShopEmployee implements Iterator<String> {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index <= fruits.size() - 1;
        }

        @Override
        public String next() {
            String fruit = fruits.get(index);
            index++;
            return fruit;
        }
    }
}
