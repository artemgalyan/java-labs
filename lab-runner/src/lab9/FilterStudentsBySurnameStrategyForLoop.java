package lab9;

import java.util.ArrayList;
import java.util.List;

public class FilterStudentsBySurnameStrategyForLoop implements FilterStudentsBySurnameStrategy {
    @Override
    public List<Student> apply(List<Student> students) {
        List<Student> result = new ArrayList<>();
        for (Student s: students) {
            if (countOfSurnames(students, s.getSurname()) > 0) {
                result.add(s);
            }
        }
        return result;
    }

    private static long countOfSurnames(List<? extends Student> students, String surname) {
        long result = 0;
        for (Student s : students) {
            if (s.getSurname().equals(surname)) {
                ++result;
            }
        }
        return result;
    }
}
