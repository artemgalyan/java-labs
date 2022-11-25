package utils;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

public abstract class ScannerPool {
    private static final HashMap<InputStream, Scanner> pool = new HashMap<>();
    private ScannerPool() {};
    public static Scanner get(InputStream stream) {
        if (pool.containsKey(stream)) {
            return pool.get(stream);
        }
        
        var scanner = new Scanner(stream);
        pool.put(stream, scanner);
        return scanner;
    }
}