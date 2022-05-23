package associativeArrays.Exercise;

import javax.xml.namespace.QName;
import java.util.*;

public class P08CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, List<String>> companyUsers = new TreeMap<>();

        while (!input.equals("End")) {
            String company = input.split(" -> ")[0];
            String id = input.split(" -> ")[1];

            if (!companyUsers.containsKey(company)) {
                companyUsers.put(company, new ArrayList<>());
            }

            if (companyUsers.containsKey(company) && !companyUsers.get(company).contains(id)) {
                companyUsers.get(company).add(id);
            }

            input = scanner.nextLine();

        }

        companyUsers.entrySet().stream().forEach(entry -> {
            System.out.println(entry.getKey());
            List<String> peoples = entry.getValue();
            peoples.stream().forEach(people -> System.out.println("-- " + people));
        });

    }
}

