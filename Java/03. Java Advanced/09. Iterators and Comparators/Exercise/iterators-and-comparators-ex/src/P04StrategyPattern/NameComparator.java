package P04StrategyPattern;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person personOne, Person personTwo) {
        int result = Integer.compare(personOne.getName().length(), personTwo.getName().length());

        if (result == 0) {
            result = Character.compare(personOne.getName().toLowerCase().charAt(0), personTwo.getName().toLowerCase().charAt(0));
        }
        return result;
    }
}
