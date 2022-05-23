import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class P12EmployeesMaximumSalaries {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();


        @SuppressWarnings("unchecked")
        List<Object[]> rows = entityManager
                .createNativeQuery("SELECT d.name, MAX(e.salary) AS `m_salary` FROM departments d\n" +
                        "JOIN employees e ON d.department_id = e.department_id\n" +
                        "GROUP BY d.name\n" +
                        "HAVING `m_salary` NOT BETWEEN 30000 AND 70000;")
                .getResultList();


        rows.stream().forEach(dep -> System.out.printf("%s %.2f%n", dep[0], dep[1]));

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
