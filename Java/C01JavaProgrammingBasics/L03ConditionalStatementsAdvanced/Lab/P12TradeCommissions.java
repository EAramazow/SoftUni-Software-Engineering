package ConditionalStatementsAdvanced.Lab;

import java.util.Scanner;

public class P12TradeCommissions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String city = scanner.nextLine();
        double sales = Double.parseDouble(scanner.nextLine());

        double bonus = 0;

        switch (city) {
            case "Sofia":
                if (sales >= 0 && sales <= 500) {
                    bonus = (sales * 0.05);

                } else if (sales > 500 && sales <= 1000) {
                    bonus = (sales * 0.07);
                } else if (sales > 1000 && sales <= 10000) {
                    bonus = (sales * 0.08);
                } else if (sales > 10000) {
                    bonus = (sales * 0.12);
                }
                break;

            case "Varna":
                if (sales >= 0 && sales <= 500) {
                    bonus = (sales * 0.045);
                } else if (sales > 500 && sales <= 1000) {
                    bonus = (sales * 0.075);
                } else if (sales > 1000 && sales <= 10000) {
                    bonus = (sales * 0.1);
                } else if (sales > 10000) {
                    bonus = (sales * 0.13);
                }
                break;


            case "Plovdiv":
                if (sales >= 0 && sales <= 500) {
                    bonus = (sales * 0.055);
                } else if (sales > 500 && sales <= 1000) {
                    bonus = (sales * 0.08);
                } else if (sales > 1000 && sales <= 10000) {
                    bonus = (sales * 0.12);
                } else if (sales > 10000) {
                    bonus = (sales * 0.145);

                }


        }

        if (city.equals("Sofia") || city.equals("Varna") || city.equals("Plovdiv") && sales > 0) {
            System.out.printf("%.2f", bonus);
        } else {
            System.out.println("error");
        }

    }
}

