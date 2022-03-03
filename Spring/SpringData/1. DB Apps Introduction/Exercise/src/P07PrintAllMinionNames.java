import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class P07PrintAllMinionNames {
    public static void main(String[] args) throws SQLException {

        Properties properties = new Properties();

        properties.setProperty("user", "root");
        System.out.println("user: root");

        System.out.print("mysql server password: ");

        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        properties.setProperty("password", password);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT name FROM minions;");

        ResultSet resultSet = preparedStatement.executeQuery();

        List<String> allMinionsNames = new ArrayList<>();

        while (resultSet.next()) {
            allMinionsNames.add(resultSet.getString("name"));
        }

        int startIndex = 0;
        int endIndex = allMinionsNames.size() - 1;

        for (int i = 0; i < allMinionsNames.size(); i++) {
            System.out.println(i % 2 == 0
                    ? allMinionsNames.get(startIndex++)
                    : allMinionsNames.get(endIndex--));
        }
        connection.close();
    }
}
