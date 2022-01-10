package L04InterfacesAndAbstraction.Exercise.P05Telephony;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] phoneNumbers = scanner.nextLine().split("\\s+");
        List<String> numbersList = new LinkedList<>(Arrays.asList(phoneNumbers));

        String[] urlsInput = scanner.nextLine().split("\\s+");
        List<String> urlsList = new LinkedList<>(Arrays.asList(urlsInput));

        Smartphone smartphone = new Smartphone(numbersList, urlsList);

        System.out.println(smartphone.call());
        System.out.println(smartphone.browse());


    }
}
