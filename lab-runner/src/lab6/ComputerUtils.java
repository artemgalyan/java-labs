package lab6;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ComputerUtils extends JFrame {

    public ComputerUtils() {
        var self = this;
        JButton button = new JButton("Turn off the PC");
        button.addActionListener(e -> {
            try {
                Runtime.getRuntime().exec("shutdown -s -t 0");
            } catch (IOException exc) {
                JOptionPane.showMessageDialog(self, "Can't do that!", "Error!", JOptionPane.ERROR_MESSAGE);
                exc.printStackTrace();
            }
            System.exit(0);
        });
        setLayout(new GridLayout(1, 1));
        add(button);
    }
}
