package lab8;

import javax.swing.*;
import java.awt.*;

public class RadioButtons extends JPanel {
    private final JRadioButton male = new JRadioButton("Male");
    private final JRadioButton female = new JRadioButton("Female");
    private final JRadioButton notDecided = new JRadioButton("Haven't decided yet");
    private ImageIcon selected, notSelected, hovered, pressed, disabled;
    private final String PATH_TO_ICONS = "src/lab8/images/";
    private final int ICON_SIZE = 25;
    public RadioButtons() {
        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);
        group.add(notDecided);
        JPanel panel = new JPanel();
        panel.add(male);
        panel.add(female);
        panel.add(notDecided);
        add(panel);
        loadIcons();
        setupRadioButton(male);
        setupRadioButton(female);
        setupRadioButton(notDecided);
    }

    private void loadIcons() {
        selected = transformIcon(new ImageIcon(PATH_TO_ICONS + "1.jpg"));
        notSelected = transformIcon(new ImageIcon(PATH_TO_ICONS + "2.jpg"));
        hovered = transformIcon(new ImageIcon(PATH_TO_ICONS + "3.jpg"));
        pressed = transformIcon(new ImageIcon(PATH_TO_ICONS + "4.jpg"));
        disabled = transformIcon(new ImageIcon(PATH_TO_ICONS + "5.jpg"));
    }

    private ImageIcon transformIcon(ImageIcon icon) {
        return new ImageIcon(
                icon.getImage()
                        .getScaledInstance(ICON_SIZE, ICON_SIZE, Image.SCALE_SMOOTH)
        );
    }
    private void setupRadioButton(JRadioButton rb) {
        rb.setSelectedIcon(selected);
        rb.setPressedIcon(pressed);
        rb.setRolloverIcon(hovered);
        rb.setIcon(notSelected);
        rb.setDisabledIcon(disabled);
    }
}
