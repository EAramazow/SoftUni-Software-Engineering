package midExam100721;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProblemThree2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = new ArrayList<>(Collections.emptyList());


        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] commands = input.split(" ");
            String typeOfCommands = commands[0];

            switch (typeOfCommands) {
                case "Chat":
                    String chatMessage = commands[1];
                    list.add(chatMessage);
                    break;
                case "Delete":
                    String deleteMessage = commands[1];
                    if (list.contains(deleteMessage)) {
                        list.remove(deleteMessage);
                    }
                    break;
                case "Edit":
                    String messageToEdit = commands[1];
                    String editedMessage = commands[2];
                    if (list.contains(messageToEdit)) {
                        list.add(list.indexOf(messageToEdit), editedMessage);
                        list.remove(messageToEdit);
//                        list.remove(messageToEdit);
//                        list.add(editedMessage);
                    }
                    break;
                case "Pin":
                    String messageToPin = commands[1];
                    if (list.contains(messageToPin)) {
                        list.remove(messageToPin);
                        list.add(messageToPin);
                    }
                    break;
                case "Spam":
                    for (int i = 1; i < commands.length; i++) {
                        list.add(commands[i]);
                    }
                    break;
            }


            input = scanner.nextLine();
        }


        for (String printList : list) {
            System.out.println(printList);
        }
    }
}
