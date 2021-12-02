package dataTypesAndVariables.moreExercise;

import java.util.Scanner;

public class DemoDataTypeFinder {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();  ;

        while (!(input.equals("END"))){
            if(input.matches("([-+]?)[0-9]{0,}"))
            {
                System.out.printf("%s is integer type\n", input);
            }
            else if (input.matches("([-+]?)[0-9]{0,}\\.([0-9]{0,})?"))
            {
                System.out.printf("%s is floating point type\n", input);
            }
            else   if(input.length() == 1){
                System.out.printf("%s is character type\n", input);
            }     else if (input.equalsIgnoreCase("true")|| input.equalsIgnoreCase("false")){
                System.out.printf("%s is boolean type\n", input);
            }     else {
                System.out.printf("%s is string type\n", input);
            }
            input = scanner.nextLine();
        }
    }
}