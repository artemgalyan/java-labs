package lab11;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class KeyLogger implements Observer<KeyEvent> {
    private final DefaultListModel<String> listModel;

    public KeyLogger(DefaultListModel<String> listModel) {
        this.listModel = listModel;
    }

    @Override
    public void notify(KeyEvent event) {
        listModel.addElement(Character.toString(event.getKeyChar()));
    }
}
