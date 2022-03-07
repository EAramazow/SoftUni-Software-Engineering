import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vehicles");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Car car = new Car("Car", "Tesla", new BigDecimal(200000), "electric", 5);
        PlateNumber carPlateNumber = new PlateNumber("AS98712HD", car);
        car.setPlate(carPlateNumber);

        entityManager.persist(car);
        entityManager.persist(carPlateNumber);


        Company company = new Company(new BigInteger("18723921873"), "Emirates");
        Plane plane = new Plane("Plane", "Boeing", new BigDecimal(2000000), "kerosene",200,  company);
        Plane secondPlane = new Plane("Plane", "Airbus", new BigDecimal(2000000), "kerosene",200,  company);
        Plane thirdPlane = new Plane("Plane", "Safran", new BigDecimal(2000000), "kerosene",200,  company);
        entityManager.persist(plane);
        entityManager.persist(secondPlane);
        entityManager.persist(thirdPlane);

        Bike bike = new Bike("Bike", "BMX", new BigDecimal(200), "");

        Truck truck = new Truck("Truck", "MAN", new BigDecimal(500000), "diesel", 6);

        entityManager.persist(truck);

        entityManager.persist(bike);

        Driver driver = new Driver("Emil Emilov", Set.of(car, truck, bike));
        car.getDrivers().add(driver);
        truck.getDrivers().add(driver);
        bike.getDrivers().add(driver);
        entityManager.persist(driver);





        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
