package basicSyntaxConditionalStatementsLoops.Exercise;

import java.util.Scanner;

public class P03Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        String groupOfPeople = scanner.nextLine();
        String dayOfWeek = scanner.nextLine();

        double price = 0;
        double peoplePrice = 0;


        switch (dayOfWeek) {
            case "Friday":
                if (groupOfPeople.equals("Students")) {
                    price = 8.45;
                    peoplePrice = numberOfPeople * price;
                    if (numberOfPeople >= 30) {
                        price = price - (price * 0.15);
                        peoplePrice = numberOfPeople * price;

                    }
                } else if (groupOfPeople.equals("Business")) {
                    price = 10.90;
                    peoplePrice = numberOfPeople * price;
                    if (numberOfPeople >= 100) {
                        peoplePrice = (numberOfPeople - 10 ) * price;
                    }
                } else if (groupOfPeople.equals("Regular")) {
                    price = 15;
                    peoplePrice = numberOfPeople * price;
                    if (numberOfPeople >= 10 && numberOfPeople <= 20) {
                        price = price - (price * 0.05);
                        peoplePrice = numberOfPeople * price;
                    }
                }
                break;

            case "Saturday":
                if (groupOfPeople.equals("Students")) {
                    price = 9.80;
                    peoplePrice = numberOfPeople * price;
                    if (numberOfPeople >= 30) {
                        price = price - (price * 0.15);
                        peoplePrice = numberOfPeople * price;
                    }
                } else if (groupOfPeople.equals("Business")) {
                    price = 15.60;
                    peoplePrice = numberOfPeople * price;
                    if (numberOfPeople >= 100) {
                        peoplePrice = (numberOfPeople - 10) * price;
                    }
                } else if (groupOfPeople.equals("Regular")) {
                    price = 20;
                    peoplePrice = numberOfPeople * price;
                    if (numberOfPeople >= 10 && numberOfPeople <= 20) {
                        price = price - (price * 0.05);
                        peoplePrice = numberOfPeople * price;
                    }
                }
                break;

            case "Sunday":
                if (groupOfPeople.equals("Students")) {
                    price = 10.46;
                    peoplePrice = numberOfPeople * price;
                    if (numberOfPeople >= 30) {
                        price = price - (price * 0.15);
                        peoplePrice = numberOfPeople * price;
                    }
                } else if (groupOfPeople.equals("Business")) {
                    price = 16;
                    peoplePrice = numberOfPeople * price;
                    if (numberOfPeople >= 100) {
                        peoplePrice = (numberOfPeople - 10) * price;
                    }
                } else if (groupOfPeople.equals("Regular")) {
                    price = 22.50;
                    peoplePrice = numberOfPeople * price;
                    if (numberOfPeople >= 10 && numberOfPeople <= 20) {
                        price = price - (price * 0.05);
                        peoplePrice = numberOfPeople * price;
                    }
                }
                break;
        }

        System.out.printf("Total price: %.2f", peoplePrice);
    }
}
