package gui;

import javax.swing.*;
import java.awt.*;
import java.io.PrintStream;

public class TaskRunnerConsole extends JPanel {
    boolean USER_CAN_WRITE_TO_TEXT_AREA = false;
    final String FONT_NAME = "Verdana";
    final int FONT_SIZE = 14;
    private final JTextArea text = new JTextArea();
    private final JTextAreaInputStream inputStream;
    private final JTextAreaOutputStream outputStream;

    public TaskRunnerConsole() {
        setLayout(new GridLayout(1, 1));
        add(text);
        inputStream = new JTextAreaInputStream(text);
        outputStream = new JTextAreaOutputStream(text);
        text.setEditable(USER_CAN_WRITE_TO_TEXT_AREA);
        setupStyle();
    }
    public void print(String append_text) {
        String old_text = text.getText();
        text.setText(old_text + append_text);
    }
    public void println(String append_text) {
        print(append_text + '\n');
    }
    public JTextAreaInputStream getInputStream() {
        return inputStream;
    }
    public PrintStream getPrintStream() {
        return new PrintStream(outputStream);
    }
    private void setupStyle() {
        text.setTabSize(2);
        text.setFont(new Font(FONT_NAME, Font.PLAIN, FONT_SIZE));
        text.setColumns(50);
    }
}
