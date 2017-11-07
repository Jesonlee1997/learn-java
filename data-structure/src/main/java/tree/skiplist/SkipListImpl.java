package tree.skiplist;

/**
 * Created by JesonLee
 * on 2017/7/5.
 */
public class SkipListImpl<K, V> implements SkipList<K, V>{
    private Node head;

    @Override
    public void put(K key, V value) {

    }

    @Override
    public V get(K key) {
        Node node = head;
        while (node.next != null) {
            node = node.next;
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    @Override
    public void delete(K k) {

    }

    @Override
    public boolean contains(K k) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public K min() {
        return null;
    }

    @Override
    public K max() {
        return null;
    }

    @Override
    public K floor(K k) {
        return null;
    }

    @Override
    public K ceiling(K k) {
        return null;
    }

    @Override
    public int rank(K k) {
        return 0;
    }

    @Override
    public K select(int k) {
        return null;
    }

    class Node {
        Node next;
        K key;
        V value;
    }
}
