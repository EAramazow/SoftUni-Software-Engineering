package diablodb;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);


        Properties properties = new Properties();
        properties.setProperty("user", "root");
        System.out.println("root");


        System.out.print("password: ");
        String password = scanner.nextLine().trim();
        properties.setProperty("password", password);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo", properties);


        PreparedStatement statement = connection.prepareStatement("SELECT user_name, first_name, last_name, COUNT(users_games.id) AS games_played FROM users"
                + " JOIN users_games ON users_games.user_id = users.id"
                + " WHERE user_name = ? "
                + " GROUP BY users_games.user_id");

        String username = scanner.nextLine();

        statement.setString(1, username);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {

            String userName = resultSet.getString("user_name");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");

            Integer gamesCount = resultSet.getInt("games_played");

            System.out.printf("User: %s%n%s %s has played %d games%n", userName, firstName, lastName, gamesCount);
        } else {
            System.out.println("No such user exists");
        }



    }
}
