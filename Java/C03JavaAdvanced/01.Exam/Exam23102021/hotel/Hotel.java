package Exam23102021.hotel;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Hotel {
    private String name;
    private int capacity;


    private Map<String, Person> roster;


    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new LinkedHashMap<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public Map<String, Person> getRoster() {
        return roster;
    }

    public void addPerson (Person person) {
        if (capacity > roster.size()) {
            this.roster.put(person.getName(), person);
        }
    }

    public boolean remove(String name) {
        Person person = this.roster.remove(name);
        return person != null;
    }

    public Person getPerson (String name, String hometown) {
        Person person = this.roster.get(name);

        if(hometown==null) {
            System.out.println("null");
            return null;
        }
        return person;
    }
    public int getCount() {
        return this.roster.size();
    }

    public String getStatistics () {
        return String.format("The people in the hotel %s are:%n%s",name,
                roster.values()
                        .stream()
                        .map(Person::toString)
                        .collect(Collectors.joining(System.lineSeparator())));
    }
    }



