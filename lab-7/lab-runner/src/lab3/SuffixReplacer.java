package lab3;

import tasks.Task;
import utils.UserDataInput;

public class SuffixReplacer implements Task {
    @Override
    public void run() {
        String expression = UserDataInput.inputString();
        if (checkInputForNull(expression))
            return;
        printResults(expression, replaceEndings(expression));
    }

    String replaceEndings(String expression) {
        return expression.replace("[.*]ing ", "$1ed");
    }
}
