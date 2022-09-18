package lab3;

import tasks.Task;
import utils.ConsoleUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExpressionCounter extends Task {
    private double x = 0;
    private static final String xString = "X";
    private static final String operations = "+-";
    private static final String operationsRegExpr = "[-+]";

    @Override
    public void run() {
        String _expression = ConsoleUtils.inputString("Input expression: ");
        if (_expression.contains(xString)) {
            x = ConsoleUtils.inputNumber("Input x: ");
        }
        try {
            double result = evaluate(_expression);
            System.out.println("Result is " + result + ".");
        } catch (Exception e) {
            System.out.println("An error occurred! \n" + e);
        } finally {
            tryAgain();
        }
    }

    private double evaluate(String _expression) {
        if (_expression.startsWith("-") || _expression.startsWith("+")) {
            _expression = "0" + _expression;
        }
        var tokens = Arrays.stream(_expression.split(operationsRegExpr)).toList();
        var operationsList = getOperands(_expression);
        return tryEvaluate(tokens, operationsList);
    }

    private double tryEvaluate(List<String> tokens, List<String> operations) {
        if (tokens.size() == 0) {
            throw new IllegalArgumentException("Tokens are empty!");
        }
        double result = tokens.get(0).equals(xString) ? x : Double.parseDouble(tokens.get(0));
        for (int i = 1; i < tokens.size(); ++i) {
            var t = tokens.get(i);
            double value = t.equals(xString) ? x : Double.parseDouble(tokens.get(i));
            if (operations.get(i - 1).equals("+")) {
                result += value;
            } else if (operations.get(i - 1).equals("-")) {
                result -= value;
            } else {
                throw new IllegalArgumentException("String contains wrong operand " + operations.get(i - 1));
            }
        }
        return result;
    }

    private List<String> getOperands(String expr) {
        var result = new ArrayList<String>();
        for (int i = 0; i < expr.length(); ++i) {
            var s = Character.toString(expr.charAt(i));
            if (operations.contains(s)) {
                result.add(s);
            }
        }
        return result;
    }
}
