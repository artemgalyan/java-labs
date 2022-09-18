package lab3;

import tasks.Task;
import utils.ConsoleUtils;

public class SuffixReplacer extends Task {
    private String suffixToReplace = "ing";
    private String newSuffix = "ed";
    private final static String spaceRegex = " +";

    @Override
    public void run() {
        var expression = ConsoleUtils.inputString("Input text: ");
        System.out.println("Result is: " + replaceEndings(expression));
        tryAgain();
    }

    String replaceEndings(String expression) {
        var newStr = expression.replace(suffixToReplace + " ", newSuffix + " ");
        if (newStr.endsWith(suffixToReplace)) {
            newStr = newStr.substring(0, newStr.length() - suffixToReplace.length()) + newSuffix;
        }
        return newStr;
    }
}
