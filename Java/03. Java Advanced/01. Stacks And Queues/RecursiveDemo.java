package StacksAndQueues.Exercise;

public class RecursiveDemo {

    private static int factorial (int number) {   // РЕКУРСИВНА ФУНКЦИЯ (рекурсивен метод - той извиква сам себе си)
        // ЗАДЪЛЖИТЕЛНО ТРЯБВА ДА ИМА ДЪНО

        if (number == 0) {
            return 1; // factorial from 0 is 1
        } else {
            return number * factorial(number - 1);
        }

    }
}
