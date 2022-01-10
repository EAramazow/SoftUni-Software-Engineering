package L03Inheritance.Lab.P04RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList <E> extends ArrayList<E> {

    public E getRandomElement() {
        int start = 0;
        int end = super.size();
        Random random = new Random();
        int randomIndex = random.nextInt(end);
        return remove(randomIndex);
    }

}
