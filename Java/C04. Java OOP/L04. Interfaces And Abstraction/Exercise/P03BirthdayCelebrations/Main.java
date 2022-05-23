package L04InterfacesAndAbstraction.Exercise.P03BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Birthable> thingsWithBirthday = new ArrayList<>();


        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String objectType = tokens[0];

            switch (objectType) {
                case "Citizen":
                    String citizenName = tokens[1];
                    int citizenAge = Integer.parseInt(tokens[2]);
                    String citizenId = tokens[3];
                    String citizenBirthday = tokens[4];
                    Citizen citizen = new Citizen(citizenName, citizenAge, citizenId, citizenBirthday);

                    thingsWithBirthday.add(citizen);
                    break;

                case "Pet":
                    String petName = tokens[1];
                    String petBirthday = tokens[2];
                    Pet pet = new Pet(petName, petBirthday);

                    thingsWithBirthday.add(pet);
                    break;

                case "Robot":
                    Robot robot = new Robot(tokens[1], tokens[2]);
                    break;

            }

            input = scanner.nextLine();
        }

        String year = scanner.nextLine();

        // boolean isFound = false;


        boolean isFound = false;

        for (Birthable birthday : thingsWithBirthday) {
            if (birthday.getBirthDate().endsWith(year)) {
                isFound = true;
                System.out.println(birthday.getBirthDate());
            }

        }

        if (!isFound) {

        }

    }

}
