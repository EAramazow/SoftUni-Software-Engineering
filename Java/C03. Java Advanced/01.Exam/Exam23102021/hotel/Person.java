package Exam23102021.hotel;

public class Person {
    private String name;
    private int id;
    private int age;


    private String hometown;

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public Person (String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.hometown = "n/a";
    }

    public Person (String name, int id, int age, String hometown) {
        this(name, id, age);
        this.hometown = hometown;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getHometown() {
        return hometown;
    }

    @Override
    public String toString() {
        return String.format("Person %s: %d, Age: %d, Hometown: %s", this.name,this.id, this.age, this.hometown);
    }
}
