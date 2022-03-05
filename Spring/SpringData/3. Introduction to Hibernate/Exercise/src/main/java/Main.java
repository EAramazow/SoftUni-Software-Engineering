import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = factory.createEntityManager();


        entityManager.getTransaction().begin();

        Town town = entityManager.find(Town.class, 1);

        entityManager.getTransaction().commit();
    }
}
