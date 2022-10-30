import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookTwo = new Book("The Documents In The Case", 1930, "Dorothy Sayers", "Robert Eustace");
        Book bookThree = new Book("The Documents In The Case", 2002);

        List<Book> books = new ArrayList<>();

        books.add(bookOne);
        books.add(bookThree);
        books.add(bookTwo);

        int end = books.size();

    // iterator example with while loop :

//        while (iterator.hasNext()) {
//            Book next = iterator.next();
//            System.out.println(next);
//        }

        // iterator example with for each loop :
//
//        for (Book next : books) {
//            System.out.println(next);
//        }


        Library library = new Library();

        library.add(bookOne);
        library.add(bookTwo);
        library.add(bookThree);


        books
                .stream()
                .sorted((f, s) -> {
                    int compared = f.getTitle().compareTo(s.getTitle());

                    if (compared == 0) {
                        compared = Integer.compare(f.getYear(), s.getYear());
                    }

                    return compared;
                })
                .forEach(System.out::println);

        for (Book next : library) {
            System.out.println(next.getTitle());
        }
    }


    }
