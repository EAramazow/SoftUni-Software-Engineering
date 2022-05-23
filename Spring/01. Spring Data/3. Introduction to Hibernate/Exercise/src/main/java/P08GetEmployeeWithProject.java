import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Comparator;
import java.util.Scanner;

public class P08GetEmployeeWithProject {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);
        int id = Integer.parseInt(scanner.nextLine());

        Employee e = entityManager.find(Employee.class, id);

        System.out.printf("%s %s - %s%n", e.getFirstName(), e.getLastName(), e.getJobTitle());

        e.getProjects().stream().sorted(Comparator.comparing(Project::getName)).forEach(p -> System.out.printf("    %s%n", p.getName()));

        entityManager.getTransaction().commit();
        entityManager.close();


    }
}
