package lab4;

import java.util.function.Consumer;

public class BinaryTreeNode<K extends Comparable<K>, V> {
    public K key;
    public V value;

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

    BinaryTreeNode<K, V> left = null;
    BinaryTreeNode<K, V> right = null;

    BinaryTreeNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    void insert(K key, V value) {
        int compareValue = key.compareTo(this.key);
        if (compareValue < 0) {
            if (left == null) {
                left = new BinaryTreeNode<>(key, value);
                return;
            }
            left.insert(key, value);
            return;
        }
        if (compareValue == 0) {
            return;
        }

        if (right == null) {
            right = new BinaryTreeNode<>(key, value);
            return;
        }
        right.insert(key, value);
    }

    BinaryTreeNode<K, V> findByKey(K k) {
        if (key.equals(k)) {
            return this;
        }

        int compareValue = k.compareTo(this.key);
        if (compareValue < 0) {
            if (left == null) {
                return null;
            }
            return left.findByKey(k);
        }
        if (right == null) {
            return null;
        }
        return right.findByKey(k);
    }

    void rootLeftRightTraverse(Consumer<BinaryTreeNode<K, V>> function) {
        function.accept(this);
        if (left != null) {
            left.rootLeftRightTraverse(function);
        }
        if (right != null) {
            right.rootLeftRightTraverse(function);
        }
    }

    void leftRightRootTraverse(Consumer<BinaryTreeNode<K, V>> function) {
        if (left != null) {
            left.leftRightRootTraverse(function);
        }
        if (right != null) {
            right.leftRightRootTraverse(function);
        }
        function.accept(this);
    }

    void leftRootRightTraverse(Consumer<BinaryTreeNode<K, V>> function) {
        if (left != null) {
            left.leftRootRightTraverse(function);
        }
        function.accept(this);
        if (right != null) {
            right.leftRootRightTraverse(function);
        }
    }
}
