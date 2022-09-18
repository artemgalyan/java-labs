package tasks;

import utils.ConsoleUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskRunner {
    private final List<TaskPackage> packages;
    private boolean printExceptions = false;
    private boolean removeIfFailed = true;

    public TaskRunner addPackage(TaskPackage tClass) {
        packages.add(tClass);
        return this;
    }

    public TaskRunner printExceptions(boolean value) {
        printExceptions = value;
        return this;
    }

    public TaskRunner removeIfFailed(boolean value) {
        removeIfFailed = value;
        return this;
    }

    public void run() {
        if (packages.isEmpty()) {
            System.out.println("Packages are empty! Nothing to run");
            return;
        }
        var names = packages.stream().map(TaskPackage::getName).toList();
        System.out.println("Select package to run: ");
        System.out.println("0. Exit");
        for (int i = 1; i <= names.size(); ++i) {
            System.out.println(i + ". " + names.get(i - 1));
        }
        var index = inputIndex(0, names.size());
        if (index == 0) {
            return;
        }
        runPackage(packages.get(index - 1));
        tryRunAgain();
    }

    public void runPackage(TaskPackage taskPackage) {
        if (taskPackage.isEmpty()) {
            System.out.println("Package " + taskPackage.getName() + " is empty!");
            return;
        }
        var names = taskPackage.getTasks().stream().map(Class::getName).toList();
        System.out.println("Select task to run: ");
        System.out.println("0. Exit");
        for (int i = 1; i <= names.size(); ++i) {
            System.out.println(i + ". " + names.get(i - 1));
        }
        var index = inputIndex(0, names.size());
        if (index == 0) {
            return;
        }
        runTask(taskPackage.getTasks().get(index - 1));
        tryRunPackageAgain(taskPackage);
    }


    public TaskRunner() {
        packages = new ArrayList<>();
    }

    private void tryRunAgain() {
        System.out.println("Do you want to reselect package? yes/no");
        var scanner = new Scanner(System.in);
        var s = scanner.nextLine();
        if (s.equals("yes"))
            run();
    }
    private void tryRunPackageAgain(TaskPackage tp) {
        System.out.println("Do you want to reselect task from package '" + tp.getName() + "'? yes/no");
        var scanner = new Scanner(System.in);
        var s = scanner.nextLine();
        if (s.equals("yes"))
            runPackage(tp);
    }

    private int inputIndex(int lowerBound, int upperBound) {
        int index = (int) ConsoleUtils.inputNumber(null);
        if (index < lowerBound || index > upperBound) {
            System.out.println("Wrong input! Try again: ");
            return inputIndex(lowerBound, upperBound);
        }
        return index;
    }

    private void runTask(Class<? extends Task> task) {
        Constructor<? extends Task> constructor;
        Task instance;
        try {
            constructor = task.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            System.err.println(task.getName() + " doesn't have default constructor, failed to create instance");
            if (printExceptions)
                e.printStackTrace();
            if (removeIfFailed)
                removeTask(task);
            return;
        } catch (SecurityException e) {
            System.err.println(task.getName() + " has private default constructor, failed to create instance");
            if (printExceptions)
                e.printStackTrace();
            if (removeIfFailed)
                removeTask(task);
            return;
        }
        try {
            instance = constructor.newInstance();
        } catch (InvocationTargetException e) {
            System.err.println("Failed to invoke constructor");
            if (printExceptions)
                e.printStackTrace();
            if (removeIfFailed)
                removeTask(task);
            return;
        } catch (InstantiationException e) {
            System.err.println("Failed to instantiate the class " + task.getName() +
                    ", check if it's not a primitive type/interface/abstract class" +
                    "/array/void/has null constructor");
            if (printExceptions)
                e.printStackTrace();
            if (removeIfFailed)
                removeTask(task);
            return;
        } catch (IllegalAccessException e) {
            System.err.println("Failed to access the constructor of " + task.getName() +
                    ", check if it is not public");
            if (printExceptions)
                e.printStackTrace();
            if (removeIfFailed)
                removeTask(task);
            return;
        }
        instance.run();
    }

    private void removeTask(Class<? extends Task> task) {
        for (var p: packages) {
            if (p.getTasks().contains(task)) {
                p.getTasks().remove(task);
                return;
            }
        }
    }
}