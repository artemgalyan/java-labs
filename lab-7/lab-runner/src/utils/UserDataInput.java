package utils;

import javax.swing.*;
import java.io.IOException;

public class UserDataInput {
    public static String inputString(String description) {
        return JOptionPane.showInputDialog(description);
    }
    public static int inputInt(String description) throws IOException {
        try {
            return Integer.parseInt(inputString(description));
        }
        catch (Exception e) {
            throw new IOException("Failed to read int!");
        }
    }
    public static double inputDouble(String description) throws IOException {
        try {
            return Double.parseDouble(inputString(description));
        } catch (Exception e) {
            throw new IOException("Failed to read double!");
        }
    }
    public static String inputString() {
        return inputString("Input string");
    }
}
