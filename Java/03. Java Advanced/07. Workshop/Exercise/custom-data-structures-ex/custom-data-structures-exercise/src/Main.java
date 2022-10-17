public class Main {
    public static void main(String[] args) {

        // LinkedList:

        LinkedList linkedList = new LinkedList();

        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);

        linkedList.addLast(4);
        linkedList.addLast(5);
        linkedList.addLast(6);

        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(2));


        System.out.println(linkedList.removeLast());

        int[] arr = linkedList.toArray();

        linkedList.forEach(System.out::println);


        // LinkedListTail:

        LinkedListTail linkedListTail = new LinkedListTail();

        linkedListTail.addFirst(1);
        linkedListTail.addFirst(2);

        linkedListTail.removeFirst();

        linkedListTail.addLast(3);
        linkedListTail.addLast(4);

        System.out.println(linkedListTail.removeLast());
        System.out.println(linkedListTail.removeLast());

        linkedListTail.forEach(System.out::println);

    }
}