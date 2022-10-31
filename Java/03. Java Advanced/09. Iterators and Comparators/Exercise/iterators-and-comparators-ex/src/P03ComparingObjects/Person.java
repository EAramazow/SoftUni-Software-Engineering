package P03ComparingObjects;

public class Person implements Comparable<Person>{

    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    public String getTown() {
        return town;
    }

    public Person setTown(String town) {
        this.town = town;
        return this;
    }

    @Override
    public int compareTo(Person otherPerson) {
        if (this.getName().equals(otherPerson.getName())) {

            if (this.getAge() == otherPerson.getAge()) {
                return this.getTown().compareTo(otherPerson.getTown());
            }
            return Integer.compare(this.getAge(), otherPerson.getAge());
        }
        return this.getName().compareTo(otherPerson.getName());
    }
}
