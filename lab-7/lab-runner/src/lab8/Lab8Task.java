package lab8;

import tasks.Task;

public class Lab8Task implements Task {
    @Override
    public void run() {
        TabsFrame frame = new TabsFrame("lab-8");
        frame.setSize(500, 500);
        frame.setLocation(100, 100);
        frame.setVisible(true);
    }
}
