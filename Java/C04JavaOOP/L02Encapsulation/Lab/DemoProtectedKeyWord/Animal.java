package L02Encapsulation.Lab.DemoProtectedKeyWord;

public class Animal {
    private double weight;
    protected double height; // имат достъп наследниците на клас Animal, но не и друг

    public Animal() {

    }


    public Animal(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

//    public void setHeight(double height) {
//        this.height = height;
//    }
}
