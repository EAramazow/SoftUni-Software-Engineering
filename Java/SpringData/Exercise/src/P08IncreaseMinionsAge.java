import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class P08IncreaseMinionsAge {
    public static void main(String[] args) throws SQLException {

        Properties properties = new Properties();

        properties.setProperty("user", "root");
        System.out.println("user: root");

        System.out.print("mysql server password: ");

        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        properties.setProperty("password", password);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        System.out.print("Enter a three minion IDs separated by space: ");

        int[] minionsIds = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        PreparedStatement setMinionAgeAndName = connection.prepareStatement(
                "UPDATE minions AS m\n" +
                        "SET m.age = m.age + 1, m.name = lower(name)\n" +
                        "WHERE m.id = ?;");


        for (int i = 0; i < minionsIds.length - 1; i++) {
            setMinionAgeAndName.setInt(1, minionsIds[i]);
            setMinionAgeAndName.executeUpdate();
        }

        PreparedStatement newMinionsInfo = connection.prepareStatement("" +
                "SELECT CONCAT_WS(' ', m.name, m.age) AS info FROM minions AS m;");

        List<String> minionsInfo = new ArrayList<>();

        ResultSet resultSet = newMinionsInfo.executeQuery();

        while (resultSet.next()) {
            minionsInfo.add(resultSet.getString("info"));
        }

        System.out.println(String.join("\n", minionsInfo));

        connection.close();

    }
}
