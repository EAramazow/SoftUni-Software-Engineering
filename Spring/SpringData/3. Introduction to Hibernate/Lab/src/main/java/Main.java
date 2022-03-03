import entities.Student;
import entities.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");

        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        Student student = new Student("Emo", 28);
        Student secondStudent = new Student("Gosho", 30);

        Teacher teacher = new Teacher("Ivan", LocalDate.now());
        entityManager.persist(teacher);

        entityManager.persist(student);
        entityManager.persist(secondStudent);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
