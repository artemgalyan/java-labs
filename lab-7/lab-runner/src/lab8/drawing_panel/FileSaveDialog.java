package lab8.drawing_panel;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;

public class FileSaveDialog extends JFileChooser {
    public FileSaveDialog() {
    }

    public FileSaveDialog(String currentDirectoryPath) {
        super(currentDirectoryPath);
    }

    public FileSaveDialog(File currentDirectory) {
        super(currentDirectory);
    }

    public FileSaveDialog(FileSystemView fsv) {
        super(fsv);
    }

    public FileSaveDialog(File currentDirectory, FileSystemView fsv) {
        super(currentDirectory, fsv);
    }

    public FileSaveDialog(String currentDirectoryPath, FileSystemView fsv) {
        super(currentDirectoryPath, fsv);
    }

    @Override
    public void approveSelection() {
        File f = getSelectedFile();
        if (f.exists()) {
            int result = JOptionPane.showConfirmDialog(this, "The file exists, overwrite?", "Existing file", JOptionPane.YES_NO_CANCEL_OPTION);

            switch (result) {
                case JOptionPane.YES_OPTION:
                    super.approveSelection();
                    return;
                case JOptionPane.NO_OPTION:
                    return;
                case JOptionPane.CLOSED_OPTION:
                    return;
                case JOptionPane.CANCEL_OPTION:
                    cancelSelection();
                    return;
            }
        }
        else {
            setSelectedFile(f);
            super.approveSelection();
        }
    }

}
