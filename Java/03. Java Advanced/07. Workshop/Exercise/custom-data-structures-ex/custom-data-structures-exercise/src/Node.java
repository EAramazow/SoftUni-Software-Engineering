public class Node {

    public int value; //vaules - 3, 5 or 7 ...
    public Node next;

    public Node (int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value + "";
    }
}
