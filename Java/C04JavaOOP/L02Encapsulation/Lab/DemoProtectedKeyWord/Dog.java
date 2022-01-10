package L02Encapsulation.Lab.DemoProtectedKeyWord;

public class Dog extends Animal {


    // можем да достъп височината, благодарение на keyword : protected
    public void setHeight(int height) {
        this.height = height;
    }
}
