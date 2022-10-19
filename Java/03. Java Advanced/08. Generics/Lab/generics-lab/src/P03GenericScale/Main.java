package P03GenericScale;

public class Main {
    public static void main(String[] args) {

       Scale<Integer> scale = new Scale(13, 143);

       System.out.println(scale.getHeavier());
       System.out.println(new Scale(143, 143).getHeavier());

    }
}
