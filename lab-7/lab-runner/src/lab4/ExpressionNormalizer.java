package lab4;

import tasks.Task;
import utils.UserDataInput;

public class ExpressionNormalizer implements Task {

    @Override
    public void run() {
        String input = UserDataInput.inputString();
        if (checkInputForNull(input))
            return;
        String normalized = normalizeString(input);
        printResults(input, normalized);
    }

    public String normalizeString(String s) {
        return s
                .replaceAll("(?<= |\\A).(?= |\\Z)", "")
                .replaceAll(" +", " ")
                .replaceAll("\\A ", "")
                .replaceAll(" \\Z", "");
    }

}