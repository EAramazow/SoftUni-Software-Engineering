package L03Inheritance.Exercise.P06Animals;

public class Tomcat extends Cat{
    private static final String GENDER = "Male";


    public Tomcat(String name, int age) {
        super(name, age, GENDER);
    }

    @Override
    public String produceSound(){
        return "MEOW";
    }
}
