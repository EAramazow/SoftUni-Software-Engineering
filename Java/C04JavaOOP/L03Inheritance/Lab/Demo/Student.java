package L03Inheritance.Lab.Demo;

import java.util.Vector;

public class Student extends Person{

    private String school;

    public Student(String name, int age, String email, String school) {
        super(name, age, email);
        this.school = school;
    }


}
