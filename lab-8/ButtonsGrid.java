package lab8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ButtonsGrid extends JPanel {
    private final int height = 10;
    private final int width = 10;
    private final String BUTTON_TEXT = ":)";
    private final Color BUTTON_DEFAULT_BACKGROUND_COLOR = Color.WHITE;
    private final Color BUTTON_HOVER_COLOR = Color.CYAN;

    public ButtonsGrid() {
        setLayout(new GridLayout(width, height));
        ButtonsMouseAdapter adapter = new ButtonsMouseAdapter();
        for (int i = 0; i < width * height; ++i) {
            JButton button = new JButton(BUTTON_TEXT);
            button.setBackground(BUTTON_DEFAULT_BACKGROUND_COLOR);
            button.addMouseListener(adapter);
            add(button);
        }
    }
    private class ButtonsMouseAdapter extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            if (!(e.getSource() instanceof JButton)) {
                super.mousePressed(e);
                return;
            }

            JButton button = (JButton) e.getSource();
            button.setText("Clicked!");
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (!(e.getSource() instanceof JButton)) {
                super.mousePressed(e);
                return;
            }

            JButton button = (JButton) e.getSource();
            button.setText(BUTTON_TEXT);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (!(e.getSource() instanceof JButton)) {
                super.mousePressed(e);
                return;
            }

            JButton button = (JButton) e.getSource();
            button.setBackground(BUTTON_HOVER_COLOR);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!(e.getSource() instanceof JButton)) {
                super.mousePressed(e);
                return;
            }

            JButton button = (JButton) e.getSource();
            button.setBackground(BUTTON_DEFAULT_BACKGROUND_COLOR);
        }
    }
}
