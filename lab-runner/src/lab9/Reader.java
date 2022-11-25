package lab9;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {
    public static List<Student> readStudentsFromFile(File file) throws IOException {
        List<Student> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                result.add(Student.fromString(scanner.nextLine()));
            }
        }
        return result;
    }
}
