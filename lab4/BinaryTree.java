package lab4;

import java.util.AbstractMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;

public class BinaryTree<K extends Comparable<K>, V> extends AbstractMap<K, V> {
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

    @Override
    public Set<Entry<K, V>> entrySet() {
        var result = new TreeSet<Entry<K, V>>(Entry.comparingByKey());
        inorderTraverse((node) -> result.add(new Entry<>() {
            @Override
            public K getKey() {
                return node.key;
            }

            @Override
            public V getValue() {
                return node.value;
            }

            @Override
            public V setValue(V value) {
                return node.value = value;
            }
        }));
        return result;
    }
}

