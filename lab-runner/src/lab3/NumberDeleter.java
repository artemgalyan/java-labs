package lab3;

import tasks.Task;
import utils.ConsoleUtils;

public class NumberDeleter extends Task {
    private final String REGEX = "((?=[,. ])|(?<=[,. ]))";

    @Override
    public void run() {
        var str = ConsoleUtils.inputString("Input string: ");
        var tokens = str.split(REGEX);
        removeNumbers(tokens);
        System.out.println("Result is: " + String.join("", tokens));
        tryAgain();
    }

    private void removeNumbers(String[] array) {
        for (int i = 0; i < array.length; ++i) {
            if (isNumber(array[i]))
                array[i] = "";
        }
    }

    private boolean isNumber(String s) {
        return s.chars().allMatch(n -> n <= '9' && n >= '0');
    }

}
