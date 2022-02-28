package orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MyConnector {
    private static Connection connection;
    private static final String connectionString = "jdbc:mysql://localhost:3306/";

    private MyConnector(){}

    public static void createConnection (String user, String password, String databaseName) throws SQLException {

        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);

        connection = DriverManager.getConnection(connectionString + databaseName, properties);

    }

    public static Connection getConnection () {

        return connection;
    }

}
