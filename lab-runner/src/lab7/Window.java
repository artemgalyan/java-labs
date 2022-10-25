package lab7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame {
    private final JPanel panel = new JPanel();
    private final JButton button = new JButton("Press me!");
    private final JLabel label = new JLabel("label");

    public Window(String title) {
        super(title);
        setFocusable(true);
        setupUi();
        setupListeners();
    }

    private void setupUi() {
        add(label, BorderLayout.SOUTH);
        panel.setLayout(null);
        panel.add(button);
        add(panel);
        button.setSize(button.getPreferredSize());
        panel.setSize(this.getSize());
    }

    private void setupListeners() {
        panel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                updatePos(e.getPoint());
                super.mouseMoved(e);
            }
        });
        ButtonMouseMovementListener listener = new ButtonMouseMovementListener(this, button);
        button.addMouseMotionListener(listener);
        button.addMouseListener(listener);
        button.addKeyListener(new ButtonKeyListener(button));
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button.setLocation(e.getPoint());
                super.mouseClicked(e);
            }
        });
    }
    void updatePos(Point p) {
        label.setText("mouse pos: " + pointToString(p));
    }

    private static String pointToString(Point p) {
        return "(" + p.x + ", " + p.y + ")";
    }
    private static class ButtonMouseMovementListener extends MouseAdapter implements MouseMotionListener {

        private int offsetX = 0;
        private int offsetY = 0;
        private final Window window;
        private final JButton button;
        private final int keyMask = KeyEvent.CTRL_DOWN_MASK;

        ButtonMouseMovementListener(Window window, JButton button) {
            this.window = window;
            this.button = button;
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            int x = button.getX() + e.getX();
            int y = button.getY() + e.getY();
            window.updatePos(new Point(x, y));

            if (keyIsPressed(e)) {
                button.setLocation(new Point(x - offsetX, y - offsetY));
            }
            super.mouseDragged(e);
        }

        private boolean keyIsPressed(MouseEvent e) {
            return (e.getModifiersEx() & keyMask) != 0;
        }
        @Override
        public void mousePressed(MouseEvent e) {
            offsetX = e.getX();
            offsetY = e.getY();
            super.mousePressed(e);
        }
    }

    private static class ButtonKeyListener extends KeyAdapter {
        private final JButton button;

        ButtonKeyListener(JButton button) {
            this.button = button;
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE) {
                removeLastCharFromButton();
            }
            else {
                appendCharToButtonText(e.getKeyChar());
            }
            super.keyReleased(e);
        }

        private void removeLastCharFromButton() {
            String text = button.getText();
            if (text.isEmpty()) {
                return;
            }

            button.setText(text.substring(0, text.length() - 1));
            updateButtonSize();
        }
        private void appendCharToButtonText(char c) {
            String text = button.getText();
            button.setText(text + c);
            updateButtonSize();
        }
        private void updateButtonSize() {
            button.setSize(button.getPreferredSize());
        }
    }
}