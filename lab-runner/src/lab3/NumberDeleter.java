package lab3;

import tasks.Task;
import utils.ConsoleUtils;

public class NumberDeleter extends Task {
    @Override
    public void run() {
        var str = ConsoleUtils.inputString("Input string: ");
        var result = str.replaceAll("((?<=[ ,.])|(?=\\A))(\\d+)((?=\\z)|(?=[ ,.]))", "");
        System.out.println("Result is: " + result);
        tryAgain();
    }

}
