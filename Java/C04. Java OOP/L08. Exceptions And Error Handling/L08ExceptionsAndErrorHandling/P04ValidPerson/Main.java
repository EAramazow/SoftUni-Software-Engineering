package L08ExceptionsAndErrorHandling.P04ValidPerson;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        Person p = new Person(null, "Last Name", 13);
//        Person p1 = new Person("First Name", null, 13);
//        Person p2 = new Person("First Name", null, -1);
//        Person p3 = new Person("First Name", null, 121);
//        Person p5 = new Person(" ", "Last Name", 25);
//        Person p6 = new Person("First Name", " ", 25);

        Person person = new Person("First Name", "Last Name", 25);

        System.out.println(person);
    }
}
