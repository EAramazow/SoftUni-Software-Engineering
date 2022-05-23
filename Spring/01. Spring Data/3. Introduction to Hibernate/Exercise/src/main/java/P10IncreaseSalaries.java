import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Set;

public class P10IncreaseSalaries {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        int affectedRows = entityManager.createQuery("UPDATE Employee e" +
                " SET e.salary = e.salary * 1.12" +
                " WHERE e.department.id IN :ids")
                .setParameter("ids", Set.of(1,2,4,11))
                .executeUpdate();

        System.out.println(affectedRows);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
