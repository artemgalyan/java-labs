package tasks;

import java.util.Scanner;

public abstract class Task {
    public abstract void run();

    protected void tryAgain() {
        System.out.println("Do you want to run task '" + this.getClass().getName() + "' again? yes/no");
        var scanner = new Scanner(System.in);
        var s = scanner.nextLine();
        if (s.equals("yes"))
            run();
    }
}
