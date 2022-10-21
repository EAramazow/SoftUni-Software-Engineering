package P05CustomList;

import java.util.Collections;

public class Sorter {

    public static <T extends Comparable<T>> void sort(CustomList<T> customList) {

        // sorting with bubble sorting algorithm :

        for (int i = 0; i < customList.size(); i++) {
            T leftElement = customList.get(i);

            for (int j = i + 1; j < customList.size(); j++) {
                T nextElement = customList.get(j);

                if (leftElement.compareTo(nextElement) > 0) {
                    customList.swap(i, j);
                }
            }
        }

    }

}
