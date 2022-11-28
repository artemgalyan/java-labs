package lab9;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.ArrayList;

public class StudentWindow extends JFrame {
    private final JList<Student> studentsList;
    private final DefaultListModel<Student> studentsModel = new DefaultListModel<>();
    private final JList<Student> processedDataList;
    private final DefaultListModel<Student> processedStudentsModel = new DefaultListModel<>();
    private final List<Student> studentList = new ArrayList<>();

    private Strategy<List<Student>, List<Student>> filter;

    public StudentWindow(String title, Strategy<List<Student>, List<Student>> filter) throws HeadlessException {
        super(title);
        this.filter = filter;
        studentsList = new JList<>(studentsModel);
        processedDataList = new JList<>(processedStudentsModel);
        addProcessButton();
        GridLayout layout = new GridLayout(1, 2);
        layout.setHgap(2);
        JPanel panel = new JPanel(layout);
        panel.add(studentsList);
        panel.add(processedDataList);
        add(panel);
        setupMenu();
    }

    public void setStrategy(Strategy<List<Student>, List<Student>> filter) {
        this.filter = filter;
    }

    private void setupMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Utils");
        JMenuItem openButton = new JMenuItem("Open file");
        openButton.setIcon(UIManager.getIcon("FileView.fileIcon"));
        openButton.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("."));
            int option = chooser.showDialog(this, "Select");
            if (option != JFileChooser.APPROVE_OPTION)
                return;

            try {
                File file = chooser.getSelectedFile();
                List<Student> fromFile = Reader.readStudentsFromFile(file);
                studentList.addAll(fromFile);
                studentsModel.clear();
                studentsModel.addAll(studentList);
            } catch (IOException exception) {
                JOptionPane.showMessageDialog(this, "Failed to open file!", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (InputMismatchException exception) {
                JOptionPane.showMessageDialog(this, "Wrong file format", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        JMenuItem addStudent = new JMenuItem("Add student");
        addStudent.setIcon(UIManager.getIcon("FileChooser.newFolderIcon"));
        addStudent.addActionListener(e -> {
            StudentBuilderFromDialog builder = new StudentBuilderFromDialog();
            Student s = builder.inputFromDialog(this, "Input student");
            if (s != null)
                addStudent(s);
        });
        JMenuItem help = new JMenuItem("Help");
        help.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "4. Дан файл, содержащий сведения о студентах (номер зачетки, фамилия, курс, группа).\n Построить алфавитный список студентов, фамилия которых встречается более одного раза\n (сортировка сразу по курсу, затем по группе, затем по студенту).",
                    "Help", JOptionPane.INFORMATION_MESSAGE);
        });
        fileMenu.add(openButton);
        menuBar.add(fileMenu);
        fileMenu.add(addStudent);
        JMenu helpMenu = new JMenu("Help");
        helpMenu.add(help);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);
    }

    private void addProcessButton() {
        JButton button = new JButton("Process data");
        button.addActionListener(e -> {
            processedStudentsModel.clear();
            List<Student> processed = filter.apply(studentList);
            processedStudentsModel.addAll(processed);
        });
        add(button, BorderLayout.SOUTH);
    }

    void addStudent(Student student) {
        studentList.add(student);
        studentsModel.addElement(student);
    }
}
