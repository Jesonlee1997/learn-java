package datastructure.tree.bplusTree;

/**
 * Created by JesonLee
 * on 2017/7/9.
 */
public interface B<K extends Comparable<K> , V> {
    V get(K key);   //查询
    void remove(K key);    //移除
    void put(K key, V obj); //插入或者更新，如果已经存在，就更新，否则插入
}
