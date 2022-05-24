package ConditionalStatementsAdvanced.Exercise;

import java.util.Scanner;

public class P08OnTimeForTheExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hourExam = Integer.parseInt(scanner.nextLine());
        int minuteExam = Integer.parseInt(scanner.nextLine());
        int hourArrived = Integer.parseInt(scanner.nextLine());
        int minuteArrived = Integer.parseInt(scanner.nextLine());


        //  Превръщане на времето в минути!


        int examTime = hourExam * 60 + minuteExam;
        int arriveTime = hourArrived * 60 + minuteArrived;

        String output = "";
        String output2 = "";
        int difference = 0;


        // Early
        if (arriveTime < examTime - 30) {
            output = "Early";
            difference = examTime - arriveTime;
            if (difference < 60) {
                output2 = String.format("%d minutes before the start", difference);


            } else {
                int h = difference / 60;
                int m = difference % 60;
                output2 = String.format("%d:%02d hours before the start", h, m);

            }


            // On Time
        } else if (arriveTime <= examTime) {
            output = "On time";
            difference = examTime - arriveTime; // може и с Math.abs
            output2 = String.format("%d minutes before the start", difference);


            // Late
        } else if (arriveTime > examTime) {
            output = "Late";
            difference = arriveTime - examTime;
            if (difference < 60) {
                output2 = String.format("%d minutes after the start", difference);
            } else {
                difference = arriveTime - examTime;
                int hours = difference / 60;
                int minutes = difference % 60;

                output2 = String.format("%d:%02d hours after the start", hours, minutes);


                // Проверка с if/else за водеща нула
                //if (minutes < 10) {
                //output2 = String.format("%d:0%d hours after the start", hours, minutes);

                //} else {
                //output2 = String.format("%d:%d hours after the start", hours, minutes);

            }
        }

        System.out.println(output);
        System.out.println(output2);


    }


}
