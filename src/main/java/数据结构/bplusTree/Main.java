package 数据结构.bplusTree;

import java.util.TreeMap;

/**
 * Created by lijs
 * on 2017/8/22.
 */
public class Main {
    public static void main(String[] args) {
        BplusTree<Integer, String> treeMap = new BplusTree<>(5);
        TreeMap<Integer, String> treeMap1 = new TreeMap<>();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000 * 1000; i++) {
            treeMap.insertOrUpdate(i, i+ "-" + 1);
        }
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        for (int i = 0; i < 1000 * 1000; i++) {
            treeMap1.put(i, i+ "-" + 1);
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}
