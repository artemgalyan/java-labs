package gui;

import tasks.Task;
import tasks.TaskPackage;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TaskRunnerGui extends JFrame {
    final String FONT_NAME = "Verdana";
    final int BUTTON_FONT_SIZE = 23;
    final int TREE_FONT_SIZE = 14;
    private JTree tree;
    private final JButton button;
    private final TaskRunnerConsole console;
    ArrayList<TaskPackage> packages;
    private DefaultMutableTreeNode selectedNode = null;

    public TaskRunnerGui(List<TaskPackage> packageList) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        packages = new ArrayList<>(packageList);
        initTree();
        setLayout(new BorderLayout(1, 1));
        setForeground(Color.WHITE);
        Container container = getContentPane();
        JScrollPane treeView = new JScrollPane(tree);
        container.add(treeView, BorderLayout.WEST);

        console = new TaskRunnerConsole();
        container.add(new JScrollPane(console));

        button = new JButton("Run");
        setupButton();
        container.add(button, BorderLayout.PAGE_END);
        System.setOut(console.getPrintStream());
        System.setErr(console.getPrintStream());

        console.println("Select a task to run");
    }
    public InputStream getInputStream() {
        return console.getInputStream();
    }
    private void initTree() {
        DefaultMutableTreeNode labs = new DefaultMutableTreeNode("labs" + " ".repeat(70));
        for (TaskPackage taskPackage: packages) {
            DefaultMutableTreeNode packageNode = new DefaultMutableTreeNode(taskPackage.getName());
            for (Class<? extends Task> task: taskPackage.getTasks()) {
                packageNode.add(new DefaultMutableTreeNode(task.getName()));
            }
            labs.add(packageNode);
        }
        tree = new JTree(labs);
        tree.addTreeSelectionListener(e -> selectedNode = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent());
        tree.setFont(new Font(FONT_NAME, Font.PLAIN, TREE_FONT_SIZE));
    }
    private void setupButton() {
        button.addActionListener(e -> {
            if (selectedNode == null)
                return;
            if (!isTask(selectedNode.toString())) {
                return;
            }
            runTask(selectedNode.toString());
        });
        button.setFont(new Font(FONT_NAME, Font.PLAIN, BUTTON_FONT_SIZE));
    }
    private boolean isTask(String name) {
        for (TaskPackage taskPackage: packages) {
            for (Class<? extends Task> task: taskPackage.getTasks()) {
                if (task.getName().equals(name)) {
                    return true;
                }
            }
        }
        return false;
    }
    private void runTask(String name) {
        for (TaskPackage taskPackage: packages) {
            for (Class<? extends Task> task: taskPackage.getTasks()) {
                if (task.getName().equals(name)) {
                    System.out.println(">>> Running task " + task.getName());
                    TaskPackage.run(task);
                    System.out.println(">>> Task " + task.getName() + " finished.\n");
                }
            }
        }
    }
}
