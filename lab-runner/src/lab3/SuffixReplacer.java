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
        var words = expression.split(spaceRegex);
        replaceEndings(words);
        System.out.println("Result is: " + String.join(" ", words));
        tryAgain();
    }

    void replaceEndings(String[] words) {
        for (int i = 0; i < words.length; ++i) {
            var word = words[i];
            if (word.endsWith("ing")) {
                int length = word.length();
                words[i] = word.substring(0, length - suffixToReplace.length()) + newSuffix;
            }
        }
    }
}
