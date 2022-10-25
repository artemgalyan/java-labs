package lab7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

public class Scholarship extends JFrame {
    private final String QUESTION = "Are you satisfied with your scholarship?";

    public Scholarship(String title) throws HeadlessException {
        super(title);
        setBackground(Color.WHITE);
        JLabel textLabel = new JLabel(QUESTION, SwingConstants.CENTER);
        textLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        textLabel.setVerticalAlignment(SwingConstants.CENTER);
        add(textLabel, BorderLayout.NORTH);
        JPanel panel = new JPanel();
        JButton yesButton = new JButton("Yes!");
        yesButton.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(yesButton);
        JButton noButton = new JButton("No!");
        noButton.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(noButton);

        add(panel);

        YesButtonHandler handler = new YesButtonHandler(yesButton);
        panel.addMouseMotionListener(handler);
        panel.addComponentListener(handler);

        noButton.addActionListener(e -> JOptionPane.showMessageDialog(null, ":(", "Sorry!", INFORMATION_MESSAGE));
        yesButton.addActionListener(e -> JOptionPane.showMessageDialog(null, ":)", "You are not supposed to do that!!", ERROR_MESSAGE));
    }

    private static class YesButtonHandler extends ComponentAdapter implements MouseMotionListener {
        private final JButton button;

        private Point buttonLocation = null;
        private boolean isInZone = false;
        private final int MIN_DISTANCE = 20;
        private int dx = 0;
        private int dy = 0;
        private double dist = 0;

        private YesButtonHandler(JButton button) {
            this.button = button;
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            mouseMoved(e);
        }

        @Override
        public void componentResized(ComponentEvent e) {
            buttonLocation = button.getLocation();
            super.componentResized(e);
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            if (buttonLocation == null) {
                buttonLocation = button.getLocation();
            }
            if (!isInRange(e.getPoint())) {
                isInZone = false;
                super.componentMoved(e);
                return;
            }

            double newDist = dist(e.getPoint());
            if (!isInZone) {
                dx = buttonLocation.x - e.getX();
                dy = buttonLocation.y - e.getY();
                dist = newDist;
                isInZone = true;
                return;
            }

            if (newDist > dist) {
                dx = buttonLocation.x - e.getX();
                dy = buttonLocation.y - e.getY();
                dist = newDist;
            }
            updateButtonPos(e);
        }

        private void updateButtonPos(MouseEvent e) {
            buttonLocation = new Point(e.getX() + dx, e.getY() + dy);
            button.setLocation(buttonLocation);
        }

        private Point getClosestPoint(Point a) {
            Point[] points = getBorderPoints();
            Point result = points[0];
            double dist = dist(result, a);
            for (Point point : points) {
                double d = dist(point, a);
                if (d < dist) {
                    dist = d;
                    result = point;
                }
            }
            return result;
        }

        private double dist(Point a, Point b) {
            return Math.max(Math.abs(a.x - b.x), Math.abs(a.y - b.y));
        }

        private Point[] getBorderPoints() {
            int height = button.getHeight();
            int width = button.getWidth();
            int x = button.getX();
            int y = button.getY();
            Point[] result = new Point[4];
            result[0] = new Point(x, y);
            result[1] = new Point(x + width, y);
            result[2] = new Point(x, y + height);
            result[3] = new Point(x + width, y + height);
            return result;
        }

        private int dist(Point p) {
            int minX = Math.abs(buttonLocation.x - p.x);
            int minY = Math.abs(buttonLocation.y - p.y);
            int maxX = Math.abs(buttonLocation.x + button.getWidth() - p.x);
            int maxY = Math.abs(buttonLocation.y + button.getHeight() - p.y);
            int minDy = Math.min(minY, maxY);
            int minDx = Math.min(minX, maxX);
            if (p.x >= buttonLocation.x && p.x <= (buttonLocation.x + button.getWidth()))
                return minDy;

            if (p.y >= buttonLocation.y && p.y <= (buttonLocation.y + button.getHeight()))
                return minDx;

            return Math.max(minDy, minDx);
        }

        private boolean isInRange(Point p) {
            return dist(p) <= MIN_DISTANCE;
        }
    }
}
