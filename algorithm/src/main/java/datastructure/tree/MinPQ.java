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
public class MinPQ<Key extends Comparable<Key>> extends PQ<Key> {
    public MinPQ() {
        super();
    }
    /**
     * 创建一个最大容量为max的优先队列
     *
     * @param max
     */
    public MinPQ(int max) {
        super(max);
    }

    public MinPQ(Key[] keys) {
        super(keys);
    }

    @Override
    protected boolean compare(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    public Key min() {
        return pq[1];
    }

    public Key delMin() {
        return del();
    }




    public static void main(String[] args) {
        int[] nums = RandomTool.getRandomArray(Integer.MAX_VALUE, 1000000);
        Integer[] data = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            data[i] = nums[i];
        }
        TimeCounter counter = TimeCounter.start();
        MinPQ<Integer> maxPQ = new MinPQ<>(data);
        int i = 0;
        while (!maxPQ.isEmpty()) {
            nums[i++] = maxPQ.delMin();
        }
        counter.end();
        System.out.println("sorted:" + Check.checkIfSorted(nums));
    }
}

