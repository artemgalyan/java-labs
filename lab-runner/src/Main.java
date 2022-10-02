import lab3.ExpressionCounter;
import lab3.NumberDeleter;
import lab3.SuffixReplacer;
import lab4.BinaryTreeTester;
import tasks.TaskPackage;
import tasks.TaskRunner;

public class Main {
    public static void main(String[] args) {
        var lab3 = new TaskPackage("lab-3");
        lab3
            .addTask(ExpressionCounter.class)
            .addTask(SuffixReplacer.class)
            .addTask(NumberDeleter.class);
        var lab4 = new TaskPackage("lab-4");
        lab4.addTask(BinaryTreeTester.class);
        var taskRunner = new TaskRunner();
        taskRunner.addPackage(lab3).addPackage(lab4);
        taskRunner.run();
        System.out.println("Exiting the app..");
    }
}