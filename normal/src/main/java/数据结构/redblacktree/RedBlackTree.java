package 数据结构.redblacktree;

/**
 * 红黑树实现
 * Created by lijs
 * on 2017/8/22.
 */
public class RedBlackTree<K extends Comparable<K>, V> {
    Node<K, V> root;

    V put(K key, V val) {
        Node<K, V> z = new Node<>(key, val);
        Node<K, V> x = root, y = null;
        while (x != null) {
            y = x;
            if (key.compareTo(x.key) < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.parent = y;
        if (y == null) {
            root = z;
        } else if (key.compareTo(y.key) < 0) {
            y.left = z;
        } else {
            y.right = z;
        }


        return null;
    }

    V get(K key) {
        return null;
    }

    static class Node<K extends Comparable<K>, V> {
        byte red;
        K key;
        V val;
        Node<K, V> left;
        Node<K, V> right;
        Node<K, V> parent;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }
}
