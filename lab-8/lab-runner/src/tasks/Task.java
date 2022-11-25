package tasks;

import java.util.Scanner;

import utils.ScannerPool;

public interface Task {
    void run();

    default void printResults(String input, String result) {
        System.out.println("Input: " + input);
        System.out.println("Result: " + result);
    }
    default boolean checkInputForNull(Object input) {
        if (input == null) {
            System.out.println("Input is null!");
            return true;
        }
        return false;
    }
    default void tryAgain() {
        System.out.println("Do you want to run task '" + this.getClass().getName() + "' again? yes/no");
        Scanner scanner = ScannerPool.get(System.in);
        var s = scanner.nextLine();
        System.out.println("Input was " + s);
        if (s.equals("yes"))
            run();
    }
}
