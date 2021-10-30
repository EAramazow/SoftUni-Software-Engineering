package FirstStepsInCoding.Exercise;

import java.util.Scanner;

public class P05BirthdayParty {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int loan = Integer.parseInt(scanner.nextLine());

        int loanHall = loan;
        double cake = loanHall * 0.20;
        double drinks = cake - cake * 0.45;
        int animator = loanHall * 1/3;
        double sum = loanHall + cake + drinks + animator;

        System.out.println(sum);

    }
}
