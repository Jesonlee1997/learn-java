package datastructure.tree;


import tool.Check;
import tool.TimeCounter;
import tool.random.RandomTool;

/**
 * 使用数组实现的优先队列
 *
 * @author JesonLee
 * @date 2017/11/4.
 */
public class MaxPQ<Key extends Comparable<Key>> extends PQ<Key> {
    public MaxPQ() {
        super();
    }

    public MaxPQ(int max) {
        super(max);
    }

    public MaxPQ(Key[] keys) {
        super(keys);
    }

    @Override
    protected boolean compare(int i, int j) {
        return pq[i].compareTo(pq[j]) > 0;
    }

    public Key max() {
        return pq[1];
    }

    public Key delMax() {
        return del();
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

