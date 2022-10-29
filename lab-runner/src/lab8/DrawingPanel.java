package lab8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class DrawingPanel extends JFrame {
    private static class Line {
        Point a, b;
        Line(Point a, Point b) {
            this.a = a;
            this.b = b;
        }

        void drawOn(Graphics g) {
            g.drawLine(a.x, a.y, b.x, b.y);
        }
    }

    private final ArrayList<Line> lines = new ArrayList<>();
    private final ArrayList<Line> linesToDraw = new ArrayList<>();
    private final Color POINT_COLOR = Color.BLACK;

    public DrawingPanel(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        DrawingPanelMouseAdapter adapter = new DrawingPanelMouseAdapter();
        addMouseMotionListener(adapter);
        addMouseListener(adapter);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (lines.isEmpty()) {
            return;
        }
        g.setColor(POINT_COLOR);
        for (Line l : lines) {
            l.drawOn(g);
        }
    }

    @Override
    public void update(Graphics g) {
        if (linesToDraw.isEmpty()) {
            return;
        }
        g.setColor(POINT_COLOR);
        for (Line l : linesToDraw) {
            l.drawOn(g);
        }
        linesToDraw.clear();
    }

    private void addLine(Line line) {
        lines.add(line);
        linesToDraw.add(line);
        update(getGraphics());
    }

    private class DrawingPanelMouseAdapter extends MouseAdapter implements MouseMotionListener {

        private Point lastPoint = null;

        @Override
        public void mouseDragged(MouseEvent e) {
            addLine(new Line(lastPoint, e.getPoint()));
            lastPoint = e.getPoint();
            super.mouseMoved(e);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            lastPoint = e.getPoint();
            super.mousePressed(e);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            lastPoint = null;
            super.mouseReleased(e);
        }
    }
}
