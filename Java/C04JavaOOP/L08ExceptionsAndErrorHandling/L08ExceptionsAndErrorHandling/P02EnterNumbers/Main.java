package L08ExceptionsAndErrorHandling.P02EnterNumbers;

import L08ExceptionsAndErrorHandling.P04ValidPerson.Person;
import L08ExceptionsAndErrorHandling.P05CustomException.Student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            Student student = new Student("4avdar", "chavdo@email.bg");
            System.out.println(student.toString());
        } catch (InvalidPersonNameException ex) {
            System.out.println(ex.getMessage());

        }

    }

}


