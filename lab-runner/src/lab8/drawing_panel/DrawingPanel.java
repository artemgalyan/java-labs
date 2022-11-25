package lab8.drawing_panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class DrawingPanel extends JPanel {
    private BufferedImage image;
    private Color color = Color.RED;

    public DrawingPanel(int imageWidth, int imageHeight) {
        image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_3BYTE_BGR);
        MouseHandler handler = new MouseHandler();
        addMouseListener(handler);
        addMouseMotionListener(handler);
        updateSize();
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
        updateSize();
        repaint();
    }

    public void createNewImage(int width, int height) {
        setImage(new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR));
    }

    public void setColor(Color color) {
        this.color = color;
    }

    private void updateSize() {
        setSize(image.getWidth(), image.getHeight());
        setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
    }

    private void addLine(Point start, Point end) {
        Graphics g = image.getGraphics();
        g.setColor(color);
        g.drawLine(start.x, start.y, end.x, end.y);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }

    private class MouseHandler extends MouseAdapter implements MouseMotionListener {
        private Point lastPoint = null;

        @Override
        public void mouseDragged(MouseEvent e) {
            if (lastPoint == null)
                return;
            addLine(lastPoint, e.getPoint());
            lastPoint = e.getPoint();
        }

        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            lastPoint = e.getPoint();
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mousePressed(e);
            lastPoint = e.getPoint();
        }


        @Override
        public void mouseReleased(MouseEvent e) {
            super.mouseReleased(e);
            lastPoint = null;
        }

        @Override
        public void mouseExited(MouseEvent e) {
            super.mouseExited(e);
            lastPoint = null;
        }
    }
}
