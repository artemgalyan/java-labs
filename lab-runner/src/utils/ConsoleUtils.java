package utils;

import java.util.Scanner;

public class ConsoleUtils {
    public static String inputString(String text) {
        if (text != null) {
            System.out.print(text);
        }
        var scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static double inputNumber(String text) {
        if (text != null) {
            System.out.print(text);
        }
        var scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }
}
