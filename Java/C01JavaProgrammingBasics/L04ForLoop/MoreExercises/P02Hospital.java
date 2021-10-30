package ForLoop.MoreExercises;

import java.util.Scanner;

public class P02Hospital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int period = Integer.parseInt(scanner.nextLine());

        int doctors = 7;
        int treatedPatients = 0;
        int untreatedPatients = 0;


        for (int i = 1; i <= period; i++) {
            int patients = Integer.parseInt(scanner.nextLine());


            if (i % 3 == 0 && untreatedPatients > treatedPatients) {
                doctors++;
            }

            if (patients > doctors) {

                untreatedPatients = untreatedPatients + patients - doctors;
                treatedPatients = treatedPatients + doctors;

            } else {

                treatedPatients = treatedPatients + patients;
            }

        }

        System.out.printf("Treated patients: %d.", treatedPatients);
        System.out.printf("\nUntreated patients: %d.", untreatedPatients);

    }
}
