package tree;

import static org.apache.commons.lang3.ArrayUtils.swap;

/**
 * @author JesonLee
 * @date 2017/11/6.
 */
public abstract class PQ<Key extends Comparable<Key>> {
    protected Key[] pq;
    protected int size;
    protected int capacity = Integer.MAX_VALUE;
    protected PQ() {
        pq = (Key[]) new Comparable[1];
    }

    /**
     * 创建一个最大容量为max的优先队列
     *
     * @param max
     */
    protected PQ(int max) {
        pq = (Key[]) new Comparable[1];
        capacity = max;
    }

    protected PQ(Key[] keys) {
        pq = (Key[]) new Comparable[keys.length + 1];
        size = pq.length - 1;
        System.arraycopy(keys, 0, pq, 1, keys.length);
        build(pq);
    }


    public void insert(Key key) {
        size++;
        resize();
        pq[size] = key;
        swim(size);
    }

    private void swim(int index) {
        while (!isRoot(index) && compare(parent(index), index)) {
            exchange(index, parent(index));
            index = parent(index);
        }
    }

    private void exchange(int index, int parent) {
        swap(pq, index, parent);
    }

    /**
     * 定义了比较规则，决定是最小堆还是最大堆
     * @param i
     * @param j
     * @return
     */
    protected abstract boolean compare(int i, int j);

    private boolean isRoot(int index) {
        return index == 1;
    }

    protected Key del() {
        if (size == 0) {
            return null;
        }
        Key result = pq[1];
        exchange(1, size--);
        pq[size + 1] = null;
        sink(1);
        resize();
        return result;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }

    private void build(Key[] pq) {
        for (int i = size / 2; i > 0; i--) {
            sink(i);
        }
    }

    protected void sink(int i) {
        int max;
        int p = i;
        while (isNotLeaf(p)) {
            int left = leftChild(p);
            int right = rightChild(p);
            max = compare(left, right) ? left : right;
            max = compare(max, p) ? max : p;
            if (max == p) {
                break;
            }
            exchange(max, p);
            p = max;
        }
    }

    void resize() {
        if (size < pq.length - 1) {
            return;
        }
        Key[] keys;
        keys = (Key[]) new Comparable[size * 2 + 1];
        System.arraycopy(pq, 1, keys, 1, size);
        pq = keys;
    }

    protected boolean isNotLeaf(int p) {
        return p <= size / 2;
    }

    protected int leftChild(int p) {
        return 2 * p;
    }

    protected int rightChild(int p) {
        int right = 2 * p + 1;
        return right > size ? size : right;
    }

    protected int parent(int c) {
        return c / 2;
    }
}
