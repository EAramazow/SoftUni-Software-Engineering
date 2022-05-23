package L03Inheritance.Lab.P04RandomArrayList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        RandomArrayList<Integer> randomArrayList = new RandomArrayList<>();

        for (int i = 1; i <= 13; i++) {
            randomArrayList.add(i);

        }

        System.out.println(randomArrayList.getRandomElement());


    }
}