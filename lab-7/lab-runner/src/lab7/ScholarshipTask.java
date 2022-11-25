package lab7;

import tasks.Task;

public class ScholarshipTask implements Task {
    @Override
    public void run() {
        var sc = new Scholarship("123");
        sc.setSize(500, 500);
        sc.setVisible(true);
    }
}
