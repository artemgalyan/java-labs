package lab7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.random.RandomGenerator;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

public class Scholarship extends JFrame {
    private final String QUESTION = "Вы любите экономику?";
    private final JLabel textLabel;
    private final JPanel buttonsPanel;

    public Scholarship(String title) throws HeadlessException {
        super(title);
        setBackground(Color.WHITE);
        textLabel = new JLabel(QUESTION, SwingConstants.CENTER);
        textLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        textLabel.setVerticalAlignment(SwingConstants.CENTER);
        add(textLabel, BorderLayout.NORTH);
        buttonsPanel = new JPanel();
        JButton yesButton = new JButton("Да!");
        yesButton.setFont(new Font("Arial", Font.PLAIN, 15));
        buttonsPanel.add(yesButton);
        JButton noButton = new JButton("Нет!");
        noButton.setFont(new Font("Arial", Font.PLAIN, 15));
        buttonsPanel.add(noButton);

        add(buttonsPanel);

        noButton.addActionListener(e -> JOptionPane.showMessageDialog(null, ":(", "Sorry!", INFORMATION_MESSAGE));
        yesButton.addActionListener(e -> JOptionPane.showMessageDialog(null, ":)", "You are not supposed to do that!!", ERROR_MESSAGE));
        yesButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Point p = generatePoint(buttonsPanel.getWidth() - yesButton.getWidth(), buttonsPanel.getHeight() - yesButton.getHeight());
                while (yesButton.contains(minus(p, yesButton.getLocation()))) {
                    p = generatePoint(buttonsPanel.getWidth() - yesButton.getWidth(), buttonsPanel.getHeight() - yesButton.getHeight());
                }
                yesButton.setLocation(p);
                super.mouseEntered(e);
            }

            private Point generatePoint(int maxX, int maxY) {
                Random r = new Random();
                return new Point(r.nextInt(0, maxX), r.nextInt(0, maxY));
            }

            private Point minus(Point a, Point b) {
                return new Point(a.x - b.x, a.y - b.y);
            }
        });
        yesButton.setFocusable(false);
    }
}
