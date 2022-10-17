public class Main {
    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();

        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);

//        linkedList.addLast(4);
//        linkedList.addLast(5);
//        linkedList.addLast(6);

        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(2));

//        linkedList.forEach(System.out::println);

    }
}