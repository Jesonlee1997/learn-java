package tree;

import tool.TimeCounter;
import tool.random.RandomTool;

import java.util.HashMap;
import java.util.Map;

/**
 * 基于线性探测的符号表
 * key为int,value为Object
 * 当设置线性探测的符号表容量非常大时,产生的hash冲突大大减少,效率有着极大的提高
 *
 * @author lijs
 * @date 17-11-9.
 */
public class LinearProbingHashingMap {
    private static final int INIT_CAPACITY = 16;

    private int size;
    private int capacity;
    private int[] keys;
    private Object[] values;

    public LinearProbingHashingMap() {
        this.capacity = INIT_CAPACITY;
        keys = new int[capacity];
        values = new Object[capacity];
    }

    public LinearProbingHashingMap(int capacity) {
        this.capacity = capacity;
        keys = new int[capacity];
        values = new Object[capacity];
    }

    public Object put(int k, Object v) {
        resize();
        int hash = hash(k);
        if (values[hash] == null) {
            setEntry(hash, k, v);
            size++;
            return null;
        }
        while (values[hash] != null) {
            if (keys[hash] == k) {
                Object old = values[hash];
                values[hash] = v;
                return old;
            }
            hash = ++hash % capacity;
        }
        setEntry(hash, k, v);
        size++;
        return null;
    }

    public Object get(int k) {
        int hash = hash(k);
        if (values[hash] == null) {
            return null;
        }
        while (values[hash] != null) {
            if (keys[hash] == k) {
                return values[hash];
            }
            hash = ++hash % capacity;
        }
        return null;
    }

    public void delete(int key) {
        int hash = hash(key);
        if (values[hash] == null) {
            return;
        }
        while (values[hash] != null) {
            if (keys[hash] == key) {
                doDelete(hash);
                break;
            }
            hash = ++hash % capacity;
        }
    }

    public int size() {
        return size;
    }

    private void setEntry(int hash, int k, Object v) {
        keys[hash] = k;
        values[hash] = v;
    }

    private void resize() {
        if (size >= capacity / 2) {
            capacity *= 2;
            int[] oldKeys = this.keys;
            Object[] oldVals = this.values;
            this.keys = new int[capacity];
            this.values = new Object[capacity];

            for (int i = 0; i < oldVals.length; i++) {
                if (oldVals[i] != null) {
                    put(oldKeys[i], oldVals[i]);
                }
            }
        }
    }

    private int hash(int k) {
        return (k ^ (k >>> 16)) % capacity;
    }

    private void doDelete(int index) {
        if (values[index] == null) {
            return;
        }
        values[index] = null;
        size--;
        while (values[(index + 1) % capacity] != null) {
            int toMove = (index + 1) % capacity;
            values[index] = values[toMove];
            keys[index] = keys[toMove];
            index = ++index % capacity;
        }
    }

    //测试其与hashMap的的效率差别
    public static void main(String[] args) {
        int size = 500 * 10000;
        LinearProbingHashingMap linearProbingHashingMap = new LinearProbingHashingMap(1024 * 10000);
        Map<Integer, Integer> hashMap = new HashMap<>(1024 * 10000);

        int[] keys1 = new int[size];
        Integer[] keys2 = new Integer[size];
        Integer[] vals = new Integer[size];

        for (int i = 0; i < size; i++) {
            int key = RandomTool.nextInt(Integer.MAX_VALUE);
            int val = RandomTool.nextInt(Integer.MAX_VALUE);

            keys1[i] = key;
            keys2[i] = key;
            vals[i] = val;
        }

        TimeCounter counter = TimeCounter.start();
        for (int i = 0; i < size; i++) {
            linearProbingHashingMap.put(keys2[i], vals[i]);
        }
        counter.end();

        TimeCounter counter2 = TimeCounter.start();
        for (int i = 0; i < size; i++) {
            hashMap.put(keys1[i], vals[i]);
        }
        counter2.end();

        check(hashMap, linearProbingHashingMap);
    }

    private static void check(Map<Integer, Integer> hashMap, LinearProbingHashingMap linearProbingHashingMap) {

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (linearProbingHashingMap.get(entry.getKey()) != entry.getValue()) {
                throw new RuntimeException("Not Equals");
            }
        }
        System.out.println("equals");
    }

}
