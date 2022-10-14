public class Main {
    public static void main(String[] args) {

        SmartArray smartArray = new SmartArray();

        smartArray.add(1);
        smartArray.add(2);
        smartArray.add(3);
        smartArray.add(4);
        smartArray.add(5);

        // 1.
        System.out.println("The numbers in SmartArray is: ");

        smartArray.forEach(System.out::println);

        // 2.
        System.out.println("The selected index from SmartArray is: ");
        System.out.println(smartArray.get(2));

        smartArray.remove(4);

        System.out.println("The numbers in SmartArray after remove method is: ");

        smartArray.forEach(System.out::println);

        smartArray.insert(0, 0);

        System.out.println("The numbers in SmartArray after insert method is: ");

        smartArray.forEach(System.out::println);


    }
}