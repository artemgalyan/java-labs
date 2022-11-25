package tasks;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class TaskPackage {
    private final List<Class<? extends Task>> tasks;
    private final String name;

    public TaskPackage(String name) {
        this.name = name;
        tasks = new ArrayList<>();
    }

    public TaskPackage addTask(Class<? extends Task> task) {
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

    public static void run(Class<? extends Task> task) {
        Constructor<? extends Task> constructor;
        Task instance;
        try {
            constructor = task.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            System.err.println(task.getName() + " doesn't have default constructor, failed to create instance");
            return;
        } catch (SecurityException e) {
            System.err.println(task.getName() + " has private default constructor, failed to create instance");
            return;
        }
        try {
            instance = constructor.newInstance();
        } catch (InvocationTargetException e) {
            System.err.println("Failed to invoke constructor");
            return;
        } catch (InstantiationException e) {
            System.err.println("Failed to instantiate the class " + task.getName() +
                    ", check if it's not a primitive type/interface/abstract class" +
                    "/array/void/has null constructor");
            return;
        } catch (IllegalAccessException e) {
            System.err.println("Failed to access the constructor of " + task.getName() +
                    ", check if it is not public");
            return;
        }
        instance.run();
    }
}
