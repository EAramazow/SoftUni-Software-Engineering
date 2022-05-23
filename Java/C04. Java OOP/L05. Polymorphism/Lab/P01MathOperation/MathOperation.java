package L05Polymorphism.Lab.P01MathOperation;

public class MathOperation {
    public int add(int f, int s){
        return f + s;
    }

    public int add(int f, int s, int t) {
        return add(add(f, s), t);
    }

    public int add(int f, int s, int t, int fth) {
        return add(add(f, s, t), fth);
    }
}
