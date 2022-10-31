package P01ListyIterator;

import java.util.Arrays;
import java.util.List;

public class ListyIterator {

    private List<String> elements;
    private int currentIndex;

    public ListyIterator(String... elements) {
        this.elements = Arrays.asList(elements);
        this.currentIndex = 0;
    }

    public boolean hasNext() {
        if (currentIndex < elements.size() - 1) {
            return true;
        }
        return false;
    }

    public boolean move() {
        if (hasNext()) {
            this.currentIndex++;
            return true;
        }
        return false;
    }

    public void print() {
        if (this.elements.size() == 0) {
            throw new IllegalStateException("Invalid Operation!");
        }
        System.out.println(this.elements.get(currentIndex));
    }
}
