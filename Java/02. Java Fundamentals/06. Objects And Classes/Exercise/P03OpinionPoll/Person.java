package objectsAndClasses.Exercise.P03OpinionPoll;

public class Person {
    // полета -> характеристики
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
// констуктор

    public Person (String name, int age) {
        this.name = name;
        this.age = age;
    }

}
