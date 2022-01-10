package L08ExceptionsAndErrorHandling.P05CustomException;

public class Student {
    private String name;
    private String email;

    public Student(String name, String email) {
        setName(name);
        setEmail(email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Validate.validateName(name);
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        Validate.validateEmail(email);
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("%s have %s email address", this.getName(), this.getEmail());
    }
}
