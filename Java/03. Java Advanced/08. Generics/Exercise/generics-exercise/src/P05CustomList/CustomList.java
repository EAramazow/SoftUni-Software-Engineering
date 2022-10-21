package P05CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {

    private List<T> elements;

    public CustomList() {
        elements = new ArrayList<>();
    }

    public void add(T element) {
        elements.add(element);
    }

    public T remove(int index) {
        return elements.remove(index);
    }

    public boolean contains(T element) {
        return elements.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        Collections.swap(elements, firstIndex, secondIndex);
    }

    public int countGreaterThan(T element) {
        return (int) elements.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public T getMax() {
//        return elements.stream().max(Comparator.naturalOrder()).get();
        return Collections.max(elements);
    }

    public T getMin() {
//        return elements.stream().min(Comparator.naturalOrder()).get();
        return Collections.min(elements);
    }

    public int size() {
        return elements.size();
    }

    public T get (int index) {
        return elements.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (T element : this.elements) {
            sb.append(element).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
