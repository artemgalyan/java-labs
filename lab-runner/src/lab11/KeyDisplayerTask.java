package lab11;

import tasks.Task;

import javax.swing.*;

public class KeyDisplayerTask implements Task {
    @Override
    public void run() {
        JFrame frame = new KeyDisplayer("Key displayer");
        frame.setBounds(100, 100, 500, 500);
        frame.setVisible(true);
    }
}
