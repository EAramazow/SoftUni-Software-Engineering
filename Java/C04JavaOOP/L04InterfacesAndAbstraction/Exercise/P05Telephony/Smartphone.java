package L04InterfacesAndAbstraction.Exercise.P05Telephony;

import java.util.List;

public class Smartphone implements Browsable, Callable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder output = new StringBuilder();

        for (String url : this.urls) {
            if (url.matches("^[^0-9]+$")) {
                output.append(String.format("Browsing: %s!\n", url));
            } else {
                output.append("Invalid URL!\n");
            }
        }
        return output.toString();
    }

    @Override
    public String call() {
        StringBuilder output = new StringBuilder();

        for (String number : this.numbers) {
            if (number.matches("^[0-9]+$")) {
                output.append(String.format("Calling... %s\n", number));
            } else {
                output.append("Invalid number!\n");
            }
        }
        return output.toString();
    }
}
