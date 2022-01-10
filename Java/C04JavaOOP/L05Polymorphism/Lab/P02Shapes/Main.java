package L05Polymorphism.Lab.P02Shapes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Shape shape = new Circle(4);
        Shape shape1 = new Rectangle(27, 13);


        printShape(shape);
        printShape(shape1);
    }

    private static void printShape(Shape shape1) {
        System.out.println(shape1.calculateArea());
        System.out.println(shape1.calculatePerimeter());
    }
}
