package lab8;

import javax.swing.*;
import java.awt.*;

public class Lists extends JPanel {
    private final DefaultListModel<Object> firstModel = new DefaultListModel<>();
    private final DefaultListModel<Object> secondModel = new DefaultListModel<>();
    private final JList<Object> firstList;
    private final JList<Object> secondList;
    private final JButton moveRightButton = new JButton(">");
    private final JButton moveLeftButton = new JButton("<");
    private final int CELL_WIDTH = 150;

    public Lists() {
        setLayout(new BorderLayout());
        setupModels();
        firstList = new JList<>(firstModel);
        secondList = new JList<>(secondModel);
        add(firstList, BorderLayout.WEST);
        add(secondList, BorderLayout.EAST);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(moveRightButton, BorderLayout.NORTH);
        panel.add(moveLeftButton, BorderLayout.SOUTH);
        add(panel);
        moveRightButton.addActionListener(e -> {
            java.util.List<Object> values = firstList.getSelectedValuesList();
            secondModel.addAll(values);
            for (Object element: values) {
                firstModel.removeElement(element);
            }
        });
        moveLeftButton.addActionListener(e -> {
            java.util.List<Object> values = secondList.getSelectedValuesList();
            firstModel.addAll(values);
            for (Object element: values) {
                secondModel.removeElement(element);
            }
        });
        firstList.setFixedCellWidth(CELL_WIDTH);
        secondList.setFixedCellWidth(CELL_WIDTH);
    }
    private void setupModels() {
        for (int i = 0; i < 5; ++i) {
            firstModel.addElement(Integer.toString(i));
        }
        for (int i = 6; i < 10; ++i) {
            secondModel.addElement(Integer.toString(i));
        }
    }
}
