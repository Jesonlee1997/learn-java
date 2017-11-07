package tree.skiplist;

/**
 * Created by JesonLee
 * on 2017/7/5.
 */
public interface SkipList<K, V> {
    void put(K key, V value);
    V get(K key);
    void delete(K k);
    boolean contains(K k);
    boolean isEmpty();
    int size();
    K min();
    K max();
    K floor(K k);//小于等于Key的最大键
    K ceiling(K k);//大于等于key的最小键
    int rank(K k);//小于key的键的数量
    K select(int k);//排名为k的键

}
