package lab4;

import tasks.Task;
import utils.UserDataInput;

public class NumberFixer implements Task {

    @Override
    public void run() {
        String str = UserDataInput.inputString();
        if (checkInputForNull(str))
            return;
        printResults(str, normalizeNumbers(str));
    }

    public String normalizeNumbers(String expression) {
        return expression
                .replaceAll("(?<=\\s|\\A)(0*)(\\d+)(\\.\\d+)?(?=\\s|\\Z)", "$2$3");
    }
}
