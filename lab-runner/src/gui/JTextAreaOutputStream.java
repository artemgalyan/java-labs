package gui;

import javax.swing.*;
import java.io.OutputStream;

public class JTextAreaOutputStream extends OutputStream {
    private final JTextArea area;

    public JTextAreaOutputStream(JTextArea area) {
        this.area = area;
    }

    @Override
    public void write(int b) {
        area.append(String.valueOf((char)b));
    }
}
