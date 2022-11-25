package lab7;

import tasks.Task;

public class ButtonDaD implements Task {
    @Override
    public void run() {
        Window w = new Window("lab-7");
        w.setSize(500, 500);
        w.setLocation(100, 100);
        w.setVisible(true);
    }
}
