package 数据结构.bplusTree;

import java.util.TreeMap;

/**
 * Created by lijs
 * on 2017/8/22.
 */
public class Main {
    public static void main(String[] args) {
        BplusTree<Integer, String> bplusTree = new BplusTree<>(5);
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000 * 1000; i++) {
            bplusTree.put(i, i+ "-" + 1);
        }
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        for (int i = 0; i < 1000 * 1000; i++) {
            treeMap.put(i, i+ "-" + 1);
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}
