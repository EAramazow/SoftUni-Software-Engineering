package P03GenericScale;

public class Scale<T extends Comparable<T>> {

    public final T left;
    public final T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {
     int compared = left.compareTo(right);

     if (compared > 0) {
         return left;
     } else if (compared < 0) {
         return right;
     }

     return null;
    }

}
