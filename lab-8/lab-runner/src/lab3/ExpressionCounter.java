package lab3;

import tasks.Task;
import utils.UserDataInput;

import java.io.IOException;
import java.util.StringTokenizer;

public class ExpressionCounter implements Task {
    private static final String xString = "x";

    @Override
    public void run() {
        String expression = UserDataInput.inputString("Input expression");
        if (checkInputForNull(expression))
            return;

        if (expression.contains(xString)) {
            int x = 0;
            try {
                x = UserDataInput.inputInt("Input x: ");
            } catch (IOException e) {
                System.out.println("Wrong input!");
                return;
            }
            expression = expression.replaceAll(xString, Integer.toString(x));
        }
        printResults(expression, Integer.toString(evaluateWithTokenizer(expression)));
    }

    private int evaluateWithTokenizer(String expression) {
        if (expression.startsWith("-") || expression.startsWith("+"))
            expression = "0" + expression;
        StringTokenizer tokenizer = new StringTokenizer(expression, "+-", true);
        int result = 0;
        boolean plus = true;
        while (tokenizer.hasMoreTokens()) {
            var value = Integer.parseInt(tokenizer.nextToken());
            if (plus)
                result += value;
            else
                result -= value;
            if (tokenizer.hasMoreTokens()) {
                var op = tokenizer.nextToken();
                plus = ("+".equals(op));
            }
        }
        return result;
    }
}