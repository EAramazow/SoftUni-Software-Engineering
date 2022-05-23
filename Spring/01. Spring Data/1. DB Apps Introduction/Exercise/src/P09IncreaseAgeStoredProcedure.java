import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class P09IncreaseAgeStoredProcedure {
    public static void main(String[] args) throws SQLException {

        Properties properties = new Properties();

        properties.setProperty("user", "root");
        System.out.println("user: root");

        System.out.print("mysql server password: ");

        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        properties.setProperty("password", password);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        System.out.println("Enter minion id: ");
        int minionId = Integer.parseInt(scanner.nextLine());

        CallableStatement callableStatement = connection.prepareCall(
                "CALL usp_get_older (?)");
        callableStatement.setInt(1, minionId);
        callableStatement.executeUpdate();

        System.out.println("Minion age increased successfully.");

        connection.close();
    }

}

