import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class P02GetVillainsName {
    public static void main(String[] args) throws SQLException {


        Properties properties = new Properties();
        properties.setProperty("user", "root");
        System.out.println("user: root");

        System.out.print("mysql server password: ");
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        properties.setProperty("password", password);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        PreparedStatement statement = connection.prepareStatement("SELECT name, COUNT(DISTINCT mv.minion_id) AS minion_count FROM villains AS v" +
                " JOIN minions_villains AS mv on mv.villain_id = v.id" +
                " GROUP BY mv.villain_id" +
                " HAVING minion_count > ?" +
                " ORDER BY minion_count DESC;");

        statement.setInt(1, 15);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String villainName = resultSet.getString("name");
            int minion_count = resultSet.getInt("minion_count");

            System.out.println(villainName + " " + minion_count);

        }

        connection.close();

    }
}