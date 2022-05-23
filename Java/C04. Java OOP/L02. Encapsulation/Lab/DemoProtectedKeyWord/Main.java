package L02Encapsulation.Lab.DemoProtectedKeyWord;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Animal animal = new Animal(34, 132);
        Dog dog = new Dog();

        dog.setHeight(30);
    }
}
