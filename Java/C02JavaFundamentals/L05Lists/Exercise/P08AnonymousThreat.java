package lists.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P08AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String namesInput = scanner.nextLine();

        List<String> names = Arrays.stream(namesInput.split("\\s+")).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("3:1")) {
            String[] commandData = command.split("\\s+");
            String commandName = commandData[0];

            if (commandName.equals("merge")) {

                int startIndex = Integer.parseInt(commandData[1]);
                int endIndex = Integer.parseInt(commandData[2]);

                if (startIndex < 0) {
                    startIndex = 0;
                }
                if (endIndex > names.size() - 1) {
                    endIndex = names.size() - 1;
                }
                    boolean isStartIndexValid = isValidIndex(startIndex, names.size());
                    boolean isEndIndexValid = isValidIndex(endIndex, names.size());


                    if (isEndIndexValid && isEndIndexValid) {

                StringBuilder resultMerge = new StringBuilder();
                for (int index = startIndex; index <= endIndex ; index++) {
                    resultMerge.append(names.get(index));
               //     names.remove(index);
               //     index--;      за премахване на елементите или още един фор цикъл
                }
                        for (int index = startIndex; index <= endIndex ; index++) {
                            names.remove(startIndex);
                        }
                names.add(startIndex, resultMerge.toString());
            }
            } else if (commandName.equals("divide")) {
                int index = Integer.parseInt(commandData[1]);
                int parts = Integer.parseInt(commandData[2]);
                String elementForDivide = names.get(index);
                names.remove(index);
                int partsSize = elementForDivide.length() / parts;
                int begin = 0;

                for (int part = 1; part < parts ; part++) {
                    names.add(index, elementForDivide.substring(begin, begin + partsSize));
                    index++;
                    begin += partsSize;
                }
                names.add(index, elementForDivide.substring(begin));
            }


            command = scanner.nextLine();
        }

        System.out.println(String.join(" ", names));

    }

    public static boolean isValidIndex(int index, int size) {
        return index >= 0 && index <= size - 1;
    }
}
