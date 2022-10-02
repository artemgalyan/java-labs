package lab4;

import tasks.Task;
public class BinaryTreeTester extends Task {
    @Override
    public void run() {
        var tree = new BinaryTree<Integer, String>();
        tree
            .insert(5, "4. Five")
            .insert(10, "6. Ten")
            .insert(3, "2. Three")
            .insert(1, "1. One")
            .insert(4, "3. Four")
            .insert(15, "7. Fifteen")
            .insert(8, "5. Eight");
        System.out.println("Left-root-right child traverse:");
        tree.leftRootRightTraverse(System.out::println);
        int SEARCH_KEY = 10;
        System.out.println("Element with key " + SEARCH_KEY + ": " + tree.findByKey(SEARCH_KEY));
        System.out.println("Finding non-existing element: " + tree.findByKey(-12413));
    }
}
