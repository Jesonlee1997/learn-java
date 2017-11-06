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

    class Node {
        Node next;
        K key;
        V value;
    }
}
