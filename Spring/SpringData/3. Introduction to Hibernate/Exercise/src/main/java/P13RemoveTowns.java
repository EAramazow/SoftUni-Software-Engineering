import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class P13RemoveTowns {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        Scanner scanner = new Scanner(System.in);
        String townName = scanner.nextLine();

        Town town = entityManager
                .createQuery("SELECT t FROM Town t" +
                        " WHERE t.name = :t_name", Town.class)
                .setParameter("t_name", townName)
                .getSingleResult();

        int affectedRows =  removeAddressesByTownId(town.getId(), entityManager);

        entityManager.remove(town);

        System.out.printf("%d address in %s is deleted", affectedRows, townName);

        entityManager.close();


    }

    private static int removeAddressesByTownId(Integer id, EntityManager entityManager) {
        entityManager.getTransaction().begin();
        int result = entityManager.createQuery("DELETE FROM Address a" +
                " WHERE a.town.id = :p_id")
                .setParameter("p_id", id).executeUpdate();
        entityManager.getTransaction().commit();

        return result;
    }
}
