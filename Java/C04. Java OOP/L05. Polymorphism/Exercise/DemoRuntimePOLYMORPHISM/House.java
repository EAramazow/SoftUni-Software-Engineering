package L05Polymorphism.Exercise.DemoRuntimePOLYMORPHISM;

public class House implements ElectronicMusic{
    @Override
    public void playMusic() {
        System.out.println("I play groovy House music!");
    }
}
