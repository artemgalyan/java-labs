package lab8;

import javax.swing.*;
import java.awt.*;

public class TabsFrame extends JFrame {
    private final JTabbedPane tabbedPane = new JTabbedPane();

    public TabsFrame(String title) throws HeadlessException {
        super(title);
        tabbedPane.addTab("Buttons grid", new ButtonsGrid());
        tabbedPane.add("Lists", new Lists());
        tabbedPane.add("Radio buttons", new RadioButtons());
        add(tabbedPane);
    }
}
