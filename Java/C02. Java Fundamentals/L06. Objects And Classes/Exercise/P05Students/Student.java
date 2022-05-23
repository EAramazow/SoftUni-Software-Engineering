package objectsAndClasses.Exercise.P05Students;

public class Student {
    // характеристики

    private String firstName;
    private String lastName;
    private double grade;

    public double getGrade() {
        return grade;
    }
// конструктор за конструиране на обект със следните параметри :

    public Student (String firstName, String lastName, double grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    // презаписваме метода toString()

    @Override
    public String toString() {
        return String.format("%s %s: %.2f", this.firstName, this.lastName, this.grade);
    }
}
