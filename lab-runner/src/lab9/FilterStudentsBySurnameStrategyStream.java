package lab9;

import java.util.List;
import java.util.stream.Collectors;

public class FilterStudentsBySurnameStrategyStream implements FilterStudentsBySurnameStrategy {
    @Override
    public List<Student> apply(List<Student> students) {
            return students.stream()
                    .filter(s -> countOfSurnames(students, s.getSurname()) > 1)
                    .collect(Collectors.toList());
    }

    private static long countOfSurnames(List<? extends Student> students, String surname) {
        return students.stream()
                .filter(s -> s.getSurname().equals(surname))
                .count();
    }
}
