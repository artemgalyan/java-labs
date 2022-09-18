package tasks;

import java.util.ArrayList;
import java.util.List;

public class TaskPackage {
    private final List<Class<? extends Task>> tasks;
    private final String name;

    public TaskPackage(String name) {
        this.name = name;
        tasks = new ArrayList<>();
    }

    public <T> TaskPackage addTask(Class<? extends Task> task) {
        tasks.add(task);
        return this;
    }

    public String getName() {
        return name;
    }

    public List<Class<? extends Task>> getTasks() {
        return tasks;
    }
    public boolean isEmpty() {
        return tasks.isEmpty();
    }
}
