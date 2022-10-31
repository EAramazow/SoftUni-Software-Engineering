package P04StrategyPattern;

import java.util.Comparator;

public class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person personOne, Person personTwo) {
        return Integer.compare(personOne.getAge(), personTwo.getAge());
    }
}
