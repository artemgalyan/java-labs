package lab3;

import tasks.Task;
import utils.ConsoleUtils;

public class SuffixReplacer implements Task {
    @Override
    public void run() {
        var expression = ConsoleUtils.inputString("Input text: ");
        System.out.println("Result is: " + replaceEndings(expression));
        tryAgain();
    }

    String replaceEndings(String expression) {
        return expression.replace("[.*]ing ", "$1ed");
    }
}
