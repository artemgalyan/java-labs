import gui.TaskRunnerGui;
import lab3.*;
import lab4.*;
import lab5.*;
import lab6.*;
import lab6.generics.*;
import lab7.*;
import lab8.*;
import lab8.drawing_panel.*;
import lab9.*;
import tasks.TaskPackage;
import tasks.TaskRunner;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        setSystemLookAndFeel();
        var lab3 = new TaskPackage("lab-3")
                .addTask(ExpressionCounter.class)
                .addTask(SuffixReplacer.class)
                .addTask(NumberDeleter.class);
        var lab4 = new TaskPackage("lab-4")
                .addTask(BinaryTreeTester.class)
                .addTask(ExpressionNormalizer.class)
                .addTask(NumberFixer.class);
        var lab5 = new TaskPackage("lab-5")
                .addTask(SeriesDemo.class)
                .addTask(CounterTasks.class);
        var lab6 = new TaskPackage("lab-6")
                .addTask(UtilsTask.class)
                .addTask(StackTester.class);
        var lab7 = new TaskPackage("lab-7")
                .addTask(ButtonDaD.class)
                .addTask(ScholarshipTask.class);
        var lab8 = new TaskPackage("lab-8")
                .addTask(Lab8Task.class)
                .addTask(DrawingWidgetTask.class);
        var lab9 = new TaskPackage("lab-9")
                .addTask(StudentsTask.class);
        var taskRunner = new TaskRunner();
        taskRunner.addPackage(lab3).addPackage(lab4).addPackage(lab5).addPackage(lab6).addPackage(lab7).addPackage(lab8).addPackage(lab9);
        TaskRunnerGui runnerGui = new TaskRunnerGui(taskRunner.getPackages());
        runnerGui.setSize(900, 500);
        runnerGui.setLocation(100, 100);
        runnerGui.setName("lab-runner");
        runnerGui.setVisible(true);
    }

    private static void setSystemLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
    }
}