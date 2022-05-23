import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Timestamp;
import java.util.Comparator;

public class P09FindLatest10Projects {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();


        entityManager.createQuery("SELECT p FROM Project p" +
                        " ORDER BY p.startDate DESC", Project.class)
                .getResultList().stream().limit(10)
                .sorted(Comparator.comparing(Project::getName))
                .forEach(p -> System.out.printf("Project name: %s%n" +
                                " \tProject description: %s%n" +
                                " \tProject start date: %s%n" +
                                " \tProject end date: %s%n",
                        p.getName(),
                        p.getDescription(),
                        p.getStartDate().toString().replace("T", " "),
                        p.getEndDate()));

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
