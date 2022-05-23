import entities.Address;
import entities.User;
import orm.EntityManager;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import static orm.MyConnector.createConnection;
import static orm.MyConnector.getConnection;

public class Main {
    public static void main(String[] args) throws SQLException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        createConnection("root", password, "custom-orm");
        Connection connection = getConnection();

        EntityManager<User> userEntityManager = new EntityManager<>(connection);
        EntityManager<Address> addressEntityManager = new EntityManager<>(connection);

        addressEntityManager.doCreate(Address.class);

        User user = new User("Pesho", 25, LocalDate.now());

        userEntityManager.persist(user);

        Iterable<User> first = userEntityManager.find(User.class);
        System.out.println(first.toString());

        User toDelete = userEntityManager.findFirst(User.class, "id > 3");
        System.out.println(toDelete);

        userEntityManager.delete(toDelete);

        Iterable<User> second = userEntityManager.find(User.class);
        System.out.println(second.toString());

        connection.close();

    }
}
