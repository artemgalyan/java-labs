package lab8.drawing_panel;

import javax.swing.*;
import java.awt.*;

public class SelectSizeDialog extends JOptionPane {
    private final int MAX_SIZE = 50000;
    private final JSpinner width = new JSpinner();
    private final JSpinner height = new JSpinner();
    private final JButton select = new JButton("Select");

    public SelectSizeDialog(Object message) {
        super(message);
        width.setModel(new SpinnerNumberModel(1000, 1, MAX_SIZE, 1));
        height.setModel(new SpinnerNumberModel(1000, 1, MAX_SIZE, 1));
        JPanel widthPanel = new JPanel();
        widthPanel.add(new JLabel("Width"));
        widthPanel.add(width);
        add(widthPanel);
        JPanel heightPanel = new JPanel();
        heightPanel.add(new JLabel("Height"));
        heightPanel.add(height);
        add(heightPanel);
    }

}
