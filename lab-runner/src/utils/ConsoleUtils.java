package utils;

import java.util.Scanner;

public class ConsoleUtils {
    public static String inputString(String text) {
        if (text != null) {
            System.out.print(text);
        }
        Scanner scanner = ScannerPool.get(System.in);
        return scanner.nextLine();
    }

    public static double inputNumberLine(String text) {
        if (text != null) {
            System.out.print(text);
        }
        Scanner scanner = ScannerPool.get(System.in);
        var d = scanner.nextDouble();
        scanner.nextLine();
        return d;
    }
}
