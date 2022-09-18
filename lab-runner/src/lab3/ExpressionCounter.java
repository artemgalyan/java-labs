package lab3;

import tasks.Task;
import utils.ConsoleUtils;

import java.util.Arrays;

public class ExpressionCounter extends Task {
    private static final String xString = "x";

    @Override
    public void run() {
        String expression = ConsoleUtils.inputString("Input expression: ");
        if (expression.contains(xString)) {
            int x = (int)ConsoleUtils.inputNumber("Input x: ");
            expression = expression.replaceAll(xString, Integer.toString(x));
        }
        System.out.println("Result is " + evaluate(expression));
    }

    private int evaluate(String expression) {
        expression = expression
                .replace(" ", "")
                .replace("-", " -")
                .replace("+", " +");
        int[] arr = Arrays.stream(expression.split(" ")).mapToInt(Integer::parseInt).toArray();
        return Arrays.stream(arr).sum();
    }
}