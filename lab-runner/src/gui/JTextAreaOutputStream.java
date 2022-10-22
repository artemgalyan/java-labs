package gui;

import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;

public class JTextAreaOutputStream extends OutputStream {
    private final JTextArea area;

    public JTextAreaOutputStream(JTextArea area) {
        this.area = area;
    }

    @Override
    public void write(int b) throws IOException {
        area.append(String.valueOf((char)b));
    }
}
