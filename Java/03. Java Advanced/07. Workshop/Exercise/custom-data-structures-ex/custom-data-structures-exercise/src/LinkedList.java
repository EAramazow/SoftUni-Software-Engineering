public class LinkedList {

    private Node head;
    private int size;


    public void addFirst(int element) {
        // 1. node object with value
        // 2. head node which will have 'next'

        Node newNode = new Node(element);

        if (!isEmpty()) {
            newNode.next = head;
        }

        this.head = newNode;
        size++;
    }

    public int removeFirst() {

        if (isEmpty()) {
            throw new IllegalStateException("Can't remove from empty list.");
        }

        int result = this.head.value;
        this.head = this.head.next;

        this.size--;

        return result;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

}
