package lab11;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class ButtonKeyDisplayer implements Observer<KeyEvent> {
    private final JLabel textLabel;

    public ButtonKeyDisplayer(JLabel textLabel) {
        this.textLabel = textLabel;
    }

    @Override
    public void notify(KeyEvent event) {
        textLabel.setText(Character.toString(event.getKeyChar()));
    }
}
