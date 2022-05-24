package L01WorkingWithAbstraction.Lab.P01RhombusOfStars;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Rhombus rhombus = new Rhombus(n);

        System.out.println(rhombus.getFigure());
    }

}





