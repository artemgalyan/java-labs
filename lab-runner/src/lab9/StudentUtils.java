package lab9;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentUtils {
    public static List<Student> filterStudentsBySurname(List<? extends Student> students) {
        List<Student> result = new ArrayList<>();
        for (Student s: students) {
            if (countOfSurnames(students, s.getSurname()) > 0) {
                result.add(s);
            }
        }
        return students.stream()
                .filter(s -> countOfSurnames(students, s.getSurname()) > 1)
                .collect(Collectors.toList());
    }

    private static long countOfSurnames(List<? extends Student> students, String surname) {
        long result = 0;
        for (Student s: students) {
            if (s.getSurname().equals(surname)) {
                ++result;
            }
        }
        return students.stream()
                .filter(s -> s.getSurname().equals(surname))
                .count();
    }
}
