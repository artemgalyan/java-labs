package lab3;

import tasks.Task;
import utils.UserDataInput;

public class NumberDeleter implements Task {
    @Override
    public void run() {
        String str = UserDataInput.inputString();
        if (checkInputForNull(str)) {
            return;
        }
        String result = str.replaceAll("((?<=[ ,.])|(?=\\A))(\\d+)((?=\\z)|(?=[ ,.]))", "");
        printResults(str, result);
    }

}
