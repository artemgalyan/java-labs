package lab8.drawing_panel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class DrawingWidget extends JFrame {
    private final String IMAGE_FORMAT = "jpg";
    private final DrawingPanel drawingPanel = new DrawingPanel(1000, 1000);
    private final JScrollPane scrollPane;
    private final JMenuItem redColorButton = new JMenuItem("Red");
    private final JMenuItem greenColorButton = new JMenuItem("Green");
    private final JMenuItem blueColorButton = new JMenuItem("Blue");
    private final JMenuItem customButtonColor = new JMenuItem("Custom color...");
    private final JMenuItem openImage = new JMenuItem("Open image");
    private final JMenuItem saveImage = new JMenuItem("Save image");
    private final JMenuItem newImage = new JMenuItem("New...");
    private final int ICON_SIZE = 20;

    public DrawingWidget(String title) throws HeadlessException {
        super(title);
        scrollPane = new JScrollPane(drawingPanel);
        add(scrollPane);
        scrollPane.setWheelScrollingEnabled(true);
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        fileMenu.add(newImage);
        fileMenu.add(openImage);
        fileMenu.add(saveImage);
        JMenu colorMenu = new JMenu("Select color");
        colorMenu.add(redColorButton);
        colorMenu.add(greenColorButton);
        colorMenu.add(blueColorButton);
        colorMenu.add(customButtonColor);
        menuBar.add(fileMenu);
        menuBar.add(colorMenu);
        setJMenuBar(menuBar);
        setupColorButtons();
        setupFileButtons();
    }

    private void setupColorButtons() {
        redColorButton.setIcon(new OvalIcon(ICON_SIZE, ICON_SIZE, Color.RED));
        greenColorButton.setIcon(new OvalIcon(ICON_SIZE, ICON_SIZE, Color.GREEN));
        blueColorButton.setIcon(new OvalIcon(ICON_SIZE, ICON_SIZE, Color.BLUE));

        redColorButton.addActionListener(e -> drawingPanel.setColor(Color.RED));
        greenColorButton.addActionListener(e -> drawingPanel.setColor(Color.GREEN));
        blueColorButton.addActionListener(e -> drawingPanel.setColor(Color.BLUE));
        customButtonColor.addActionListener(e -> {
            Color selectedColor = JColorChooser.showDialog(this, "Select color", null);
            drawingPanel.setColor(selectedColor);
        });
    }

    private void setupFileButtons() {
        newImage.addActionListener(e -> drawingPanel.createNewImage(1000, 1000));
        openImage.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("."));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", ImageIO.getReaderFormatNames());
            chooser.setFileFilter(filter);
            int result = chooser.showDialog(this, "Open");
            if (result != JFileChooser.APPROVE_OPTION)
                return;
            File file = chooser.getSelectedFile();
            try {
                BufferedImage in = ImageIO.read(file);
                BufferedImage image = new BufferedImage(in.getWidth(), in.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
                Graphics g = image.getGraphics();
                g.drawImage(in, 0, 0, null);
                g.dispose();
                drawingPanel.setImage(image);
            } catch (IOException | NullPointerException ex) {
                JOptionPane.showMessageDialog(this, "Failed to read image", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        });
        saveImage.addActionListener(e -> {
            BufferedImage image = drawingPanel.getImage();
            FileSaveDialog saver = new FileSaveDialog();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Images (." + IMAGE_FORMAT + ")", IMAGE_FORMAT);
            saver.setFileFilter(filter);
            saver.setCurrentDirectory(new File("."));
            saver.setAcceptAllFileFilterUsed(false);
            int result = saver.showDialog(this, "Save");
            if (result != JFileChooser.APPROVE_OPTION)
                return;
            try {
                File file = saver.getSelectedFile();
                if (!file.getName().endsWith(IMAGE_FORMAT))
                    file = new File(file.getAbsolutePath() + "." + IMAGE_FORMAT);
                ImageIO.write(image, IMAGE_FORMAT, file);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Failed to save image", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
