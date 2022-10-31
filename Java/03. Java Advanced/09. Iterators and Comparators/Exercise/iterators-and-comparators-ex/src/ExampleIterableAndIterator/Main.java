package ExampleIterableAndIterator;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        Shelf shelf = new Shelf("Apple", "Banana", "Orange", "Kiwi");

        Iterator<String> shop = shelf.iterator();

//        while (shop.hasNext()) {
//            System.out.println(shop.next());
//        }

        for (String fruit : shelf) {
            System.out.println(fruit);
        }
    }
}
