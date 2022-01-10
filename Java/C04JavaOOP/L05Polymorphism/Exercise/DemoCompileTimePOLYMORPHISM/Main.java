package L05Polymorphism.Exercise.DemoCompileTimePOLYMORPHISM;

public class Main {
    public static void main(String[] args) {


        //COMPILE TIME POLYMORPHISM използваме OVERLOAD-ване

        SumOperation sumOperation = new SumOperation();

        sumOperation.sum(1, 2);
        sumOperation.sum(1,2,3);

    }
}