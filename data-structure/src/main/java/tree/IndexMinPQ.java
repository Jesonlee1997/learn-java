package tree;


import java.util.HashMap;
import java.util.Map;

/**
 * 索引优先队列
 * @author JesonLee
 * @date 2017/11/6.
 */
public class IndexMinPQ<Item extends Comparable<Item>> {
    private Map<Integer, Item> idxMap;
    private MinPQ<Integer> pq;

    private int size;

    public IndexMinPQ(int capacity) {
        idxMap = new HashMap<>(capacity);
        pq = new MinPQ<>(capacity);
    }

    public void insert(int k, Item item) {
        pq.insert(k);
        idxMap.put(k, item);
    }

    /**
     * 把索引为k的元素设为Item
     * @param k
     * @param item
     */
    public void change(int k, Item item) {
        idxMap.put(k, item);
    }

    public boolean contains(int k) {
        return idxMap.containsKey(k);
    }

    void delete(int k) {
        idxMap.remove(k);
    }

    public Item min() {
        return idxMap.get(pq.min());
    }

    /**
     * 返回最小元素的索引
     * @return
     */
    public int minIndex() {
        return pq.min();
    }

    int delMin() {
        int min = pq.delMin();
        idxMap.remove(min);
        return min;
    }

    private boolean isEmpty() {
        return size() == 0;
    }

    private int size() {
        return idxMap.size();
    }

}
