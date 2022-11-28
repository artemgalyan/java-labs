package lab9;

import tasks.Task;

public class StudentsTask implements Task {
    @Override
    public void run() {
        StudentWindow window = new StudentWindow("Students", new FilterStudentsBySurnameStrategyForLoop());
        window.setBounds(100, 100, 800, 500);
        window.setVisible(true);
        window.setStrategy(new FilterStudentsBySurnameStrategyStream());
    }
}
