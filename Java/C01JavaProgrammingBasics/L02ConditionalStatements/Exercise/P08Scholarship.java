package ConditionalStatements.Exercise;

import java.util.Scanner;

public class P08Scholarship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double income = Double.parseDouble(scanner.nextLine());
        double avgSuccess = Double.parseDouble(scanner.nextLine());
        double minSalary = Double.parseDouble(scanner.nextLine());

        // 1. Проверка за социална стипендия
        // 2. Проверка за отлична стипендия
        // if      // 3. Проверка дали изобщо може да получи някаква стипендия (социална или отлична)
        // else if // 4. Проверка коя стипендия е по-висока и ще дадем нея

        double socialScholarship = 0.0;
        double excellentScholarship = 0.0;
        // 1. Проверка за социална стипендия
        if (income < minSalary) {
            if (avgSuccess > 4.50) {
                socialScholarship = Math.floor(minSalary * 0.35);
            }

            // 2. Проверка за отлична стипендия
            if (avgSuccess >= 5.50) {
                excellentScholarship = Math.floor(avgSuccess * 25);
            }

         // 3. Дали изобщо може да получи някаква стипендия
         // §§ оператора сравнява socialScholarship и excellentScholarship дали и двете са true, ако едното е false, всичко е false
           if (socialScholarship == 0 && excellentScholarship == 0) {

               System.out.println("You cannot get a scholarship!");
           // 4. Проверка коя стипендия е по-висока и ще дадем нея
           } else if (socialScholarship > excellentScholarship) {
               System.out.printf("You get a Social scholarship %.0f BGN", socialScholarship);
           }else if (excellentScholarship >= socialScholarship ) {
               System.out.printf("You get a scholarship for excellent results %.0f BGN", excellentScholarship);
           }

        }

    }

}
