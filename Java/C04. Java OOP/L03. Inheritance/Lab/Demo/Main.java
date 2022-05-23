package L03Inheritance.Lab.Demo;

import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Ivan", 32, "ivan@email.com");

        Employee employee = new Employee("Emil", 28, "emil@mail.com", "Softuni");

        System.out.println(person.getInfo());
        System.out.println(employee.getInfo());




        String name = "Mimi";
        Vector<String> vector = new Vector<>();

    }
}