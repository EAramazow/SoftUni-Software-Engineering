package P02GenericArrayCreator;

public class Main {
    public static void main(String[] args) {

        Integer[] integers = ArrayCreator
                .<Integer>create(10, 13);

        String[] strings = ArrayCreator
                .<String>create(5, "Emo");

        for (Integer integer : integers) {
            System.out.println(integer);
        }

        for (String string : strings) {
            System.out.println(string);
        }
        
    }
}
