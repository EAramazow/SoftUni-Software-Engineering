package L04InterfacesAndAbstraction.Lab.P05BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        List<Identifiable> identifiableList = new ArrayList<>();

        while (!line.equals("End")) {
            String[] tokens = line.split("\\s+");
            String name = tokens[0];

            Identifiable identifiable = tokens.length == 2

                    // ? ako ... (true)
                    ?  new Robot(tokens[0], tokens[1])
                    // : в противен случай ... (false)
                    : new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);

            identifiableList.add(identifiable);


            line = scanner.nextLine();
        }


        String lastFakeDigits = scanner.nextLine();

        System.out.println(identifiableList.stream()
                .map(Identifiable::getId)
                .filter(id -> id.endsWith(lastFakeDigits))
                .collect(Collectors.joining(System.lineSeparator())));


    }
}
