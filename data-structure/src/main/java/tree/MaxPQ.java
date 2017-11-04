package tree;


import tool.Check;
import tool.TimeCounter;
import tool.random.RandomTool;

import static org.apache.commons.lang3.ArrayUtils.swap;

/**
 * 使用数组实现的优先队列
 *
 * @author JesonLee
 * @date 2017/11/4.
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int size;

    public MaxPQ() {
        pq = (Key[]) new Comparable[1];
    }

    /**
     * 创建一个最大容量为max的优先队列
     *
     * @param max
     */
    public MaxPQ(int max) {
        pq = (Key[]) new Comparable[max + 1];
        size = pq.length - 1;
        build(pq);
    }

    public MaxPQ(Key[] keys) {
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
        while (!isRoot(index)) {
            int parent = parent(index);
            if (pq[index].compareTo(pq[parent]) > 0) {
                swap(pq, index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    private boolean isRoot(int index) {
        return index == 1;
    }

    public Key max() {
        return pq[1];
    }

    public Key delMax() {
        if (size == 0) {
            return null;
        }
        Key result = pq[1];
        del(1);
        resize();
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void build(Key[] pq) {
        for (int i = size / 2; i > 0; i--) {
            sink(i);
        }
    }

    private void sink(int i) {
        int max;
        int p = i;
        while (isNotLeaf(p)) {
            int left = leftChild(p);
            int right = rightChild(p);
            max = pq[left].compareTo(pq[right]) > 0 ? left : right;
            max = pq[max].compareTo(pq[p]) > 0 ? max : p;
            if (max == p) {
                break;
            }
            swap(pq, max, p);
            p = max;
        }
    }

    private void del(int p) {
        int max;
        while (isNotLeaf(p)) {
            int left = leftChild(p);
            int right = rightChild(p);
            max = pq[left].compareTo(pq[right]) > 0 ? left : right;
            pq[p] = pq[max];
            p = max;
        }
        size--;
    }

    private void resize() {
        if (size < pq.length - 1) {
            return;
        }
        Key[] keys;
        keys = (Key[]) new Comparable[size * 2 + 1];
        System.arraycopy(pq, 1, keys, 1, size);
        pq = keys;
    }

    private boolean isNotLeaf(int p) {
        return p <= size / 2;
    }

    private int leftChild(int p) {
        return 2 * p;
    }

    private int rightChild(int p) {
        int right = 2 * p + 1;
        return right > size ? size : right;
    }

    private int parent(int c) {
        return c / 2;
    }


    public static void main(String[] args) {
        int[] nums = RandomTool.getRandomArray(Integer.MAX_VALUE, 1000000);
        Integer[] data = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            data[i] = nums[i];
        }
        TimeCounter counter = TimeCounter.start();
        MaxPQ<Integer> maxPQ = new MaxPQ<>(data);
        int i = 0;
        while (!maxPQ.isEmpty()) {
            nums[i++] = maxPQ.delMax();
        }
        counter.end();
        System.out.println("sorted:" + Check.checkIfSortedDesc(nums));
    }
}

