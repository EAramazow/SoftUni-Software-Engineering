import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class P03GetMinionsName {
    public static void main(String[] args) throws SQLException {

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        System.out.println("user: root");

        System.out.print("mysql server password: ");
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        properties.setProperty("password", password);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        System.out.print("Enter a Villain ID: ");

        int villainId = Integer.parseInt(scanner.nextLine());

        PreparedStatement villainStatement = connection.prepareStatement("SELECT name FROM villains WHERE id = ?");

        villainStatement.setInt(1, villainId);

        ResultSet villainSet = villainStatement.executeQuery();

        if (!villainSet.next()) {
            System.out.printf("No villain with ID %d exists in the database.", villainId);
            return;
        }

        String villainName = villainSet.getString("name");
        System.out.println("Villain: " + villainName);

        PreparedStatement minionStatement = connection.prepareStatement("SELECT name, age" +
                " FROM minions AS m" +
                " JOIN minions_villains AS mv ON mv.minion_id = m.id" +
                " WHERE mv.villain_id = ?;");

        minionStatement.setInt(1, villainId);

        ResultSet minionSet = minionStatement.executeQuery();

        for (int i = 1; minionSet.next(); i++) {
         String name = minionSet.getString("name");
         int age = minionSet.getInt("age");

            System.out.printf("%d. %s %d%n", i,name,age);

        }

        connection.close();
    }
}
