package P01GenericBox;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {

    List<T> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void add(T element) {
        values.add(element);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (T element : values) {
            sb.append(String.format("%s: %s", element.getClass().getName(), element.toString()))
                    .append(System.lineSeparator());
        }

        return sb.toString();
    }
}
