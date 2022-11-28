package lab11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class KeyDisplayer extends JFrame implements Observable<KeyEvent> {
    private final JLabel buttonLabel = new JLabel("No button is pressed");
    private final DefaultListModel<String> pressedKeys = new DefaultListModel<>();
    private final ArrayList<Observer<KeyEvent>> observers = new ArrayList<>();
    private final Font font = new Font("Arial", Font.PLAIN, 15);

    public KeyDisplayer(String title) throws HeadlessException {
        super(title);
        buttonLabel.setFont(font);
        add(buttonLabel, BorderLayout.WEST);
        pressedKeys.addElement("There will be your pressed keys.");
        JList<String> history = new JList<>(pressedKeys);
        history.setFont(font);
        add(new JScrollPane(history), BorderLayout.EAST);
        addObserver(new ButtonKeyDisplayer(buttonLabel));
        addObserver(new KeyLogger(pressedKeys));
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                notifyObservers(e);
                super.keyPressed(e);
            }
        });
        setFocusable(true);
    }

    @Override
    public void addObserver(Observer<KeyEvent> observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer<KeyEvent> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(KeyEvent event) {
        for (Observer<KeyEvent> o: observers) {
            o.notify(event);
        }
    }
}
