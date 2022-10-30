package P01Book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookTwo = new Book("The Documents In The Case", 1930, "Dorothy Sayers", "Robert Eustace");
        Book bookThree = new Book("The Documents In The Case", 2002);

        List<Book> books = new ArrayList<>();

        books.add(bookOne);
        books.add(bookTwo);
        books.add(bookThree);

        int end = books.size();

//        while (iterator.hasNext()) {
//            Book next = iterator.next();
//            System.out.println(next);
//        }


        for (Book next : books) {
            System.out.println(next);
        }

        for (int begin = 0; begin < end; begin++) {
            Book nextBook = books.get(begin);

            System.out.println(nextBook.getTitle());
        }

    }
}