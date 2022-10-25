package lab4;

import java.util.Scanner;

import tasks.Task;

public class ExpressionNormalizer implements Task {

    @Override
    public void run() {
        var scanner = new Scanner(System.in);
        System.out.println("Input string: ");
        var input = scanner.nextLine();
        var normalized = normalizeString(input);
        System.out.println("Result is: " + normalized + ";");
        tryAgain();
    }

    public String normalizeString(String s) {
        return s
                .replaceAll("(?<= |\\A).(?= |\\Z)", "")
                .replaceAll(" +", " ")
                .replaceAll("\\A ", "")
                .replaceAll(" \\Z", "");
    }

}