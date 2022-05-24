package L05Polymorphism.Exercise.DemoCompileTimePOLYMORPHISM;

public class SumOperation {

    // ТЕРМИН : КОГАТО ИМАМЕ МЕТОД С ЕДНАКВО ИМЕ НО С РАЗЛИЧЕН БРОЙ ИЛИ ВИД АРГУМЕНТИ - OVERLOADING  !!!
    // МЕТОД, КОЙТО ИМА РАЗЛИЧНИ ИМПЛЕМЕНТАЦИИ



    public int sum (int a, int b) {
        return a + b;
    }

    public int sum (int a, int b, int c) {
        return a + b + c;
    }
}
