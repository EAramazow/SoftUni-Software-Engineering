package L03Inheritance.Lab.Demo;

public class Employee extends Person {
    private String companyName;

    public Employee (String name, int age, String email, String companyName) {
        super(name, age, email);     // базов конструктор не ни трябва. По този начин инициализиране извикваме конструктора на базовия клас Person.
        this.companyName = companyName;



        // super() - обръщам се към конструктор, който идва от базов клас
        // this. - за референция към текущия клас (Peron)
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " I work for " + companyName + ".";
    }
}
