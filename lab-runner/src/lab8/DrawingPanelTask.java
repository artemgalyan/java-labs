package lab8;

import tasks.Task;

public class DrawingPanelTask implements Task {
    public static void main(String[] args) {
        Task t = new DrawingPanelTask();
        t.run();
    }
    @Override
    public void run() {
        DrawingPanel panel = new DrawingPanel("Drawing panel");
        panel.setSize(500, 500);
        panel.setLocation(150, 150);
        panel.setVisible(true);
    }
}
