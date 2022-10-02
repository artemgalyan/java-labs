package lab3;

import tasks.Task;
import utils.ConsoleUtils;

import java.util.Arrays;
import java.util.StringTokenizer;

public class ExpressionCounter extends Task {
    private static final String xString = "x";

    @Override
    public void run() {
        String expression = ConsoleUtils.inputString("Input expression: ");
        if (expression.contains(xString)) {
            int x = (int)ConsoleUtils.inputNumber("Input x: ");
            expression = expression.replaceAll(xString, Integer.toString(x));
        }
        System.out.println("Result is " + evaluate_with_tokenizer(expression));
    }

    private int evaluate_with_tokenizer(String expression) {
        if (expression.startsWith("-") || expression.startsWith("+"))
            expression = "0" + expression;
        var tokenizer = new StringTokenizer(expression, "+-", true);
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