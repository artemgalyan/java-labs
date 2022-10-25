package lab4;

import tasks.Task;

import java.util.Scanner;

public class NumberFixer implements Task {

    @Override
    public void run() {
        var scanner = new Scanner(System.in);
        System.out.println("Input string: ");
        var str = scanner.nextLine();
        System.out.println("Fixed string: " + normalizeNumbers(str));
        tryAgain();
    }

    public String normalizeNumbers(String expression) {
        return expression
                .replaceAll("(0*)(\\w+)(\\.\\d+)?", "$2$3");
    }
}
