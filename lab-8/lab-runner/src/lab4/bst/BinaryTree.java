package lab4.bst;

import java.util.function.Consumer;

public class BinaryTree<K extends Comparable<K>, V> {
    private BinaryTreeNode<K, V> root = null;

    public BinaryTree<K, V> insert(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("key is null");
        }
        if (root == null) {
            root = new BinaryTreeNode<>(key, value);
            return this;
        }
        root.insert(key, value);
        return this;
    }

    public BinaryTreeNode<K, V> findByKey(K key) {
        if (root == null) {
            return null;
        }

        return root.findByKey(key);
    }

    public void preorderTraverse(Consumer<BinaryTreeNode<K, V>> function) {
        if (root != null) {
            root.preorderTraverse(function);
        }
    }

    public void postorderTraverse(Consumer<BinaryTreeNode<K, V>> function) {
        if (root != null) {
            root.postorderTraverse(function);
        }
    }

    public void inorderTraverse(Consumer<BinaryTreeNode<K, V>> function) {
        if (root != null) {
            root.inorderTraverse(function);
        }
    }
}

