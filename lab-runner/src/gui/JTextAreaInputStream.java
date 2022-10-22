package gui;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class JTextAreaInputStream extends InputStream {
    private final StringBuilder data = new StringBuilder();
    public JTextAreaInputStream(final JTextArea area) {
        area.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                data.append(e.getKeyChar());
                super.keyReleased(e);
            }
        });
    }

    @Override
    public int read(@NotNull byte[] b, int off, int len) throws IOException {

        Objects.checkFromIndexSize(off, len, b.length);
        if (len == 0) {
            return 0;
        }

        int c = read();
        if (c == -1) {
            return -1;
        }
        b[off] = (byte)c;

        int i = 1;
        try {
            for (; i < len && available() > 0 ; i++) {
                c = read();
                if (c == -1) {
                    break;
                }
                b[off + i] = (byte)c;
            }
        } catch (IOException ee) {
        }
        return i;
    }

    @Override
    public int available() throws IOException {
        return data.length();
    }

    @Override
    public int read() throws IOException {
        if (data.isEmpty())
            return -1;
        char c = data.charAt(0);
        data.deleteCharAt(0);
        return c;
    }
}