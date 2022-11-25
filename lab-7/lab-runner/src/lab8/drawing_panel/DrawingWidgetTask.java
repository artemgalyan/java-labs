package lab8.drawing_panel;

import tasks.Task;

public class DrawingWidgetTask implements Task {
    @Override
    public void run() {
        DrawingWidget widget = new DrawingWidget("Paint!");
        widget.setSize(500, 500);
        widget.setLocation(100, 100);
        widget.setVisible(true);
    }
}
