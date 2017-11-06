package tree.skiplist;

/**
 * Created by JesonLee
 * on 2017/7/5.
 */
public interface SkipList<K, V> {
    void put(K key, V value);
    V get(K key);
}
