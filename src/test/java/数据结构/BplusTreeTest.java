package 数据结构;

import org.junit.Test;
import 数据结构.bplusTree.BplusTree;

/**
 * Created by JesonLee
 * on 2017/7/9.
 */
public class BplusTreeTest {
    private BplusTree bplusTree;

    @Test
    public void get() throws Exception {
    }

    @Test
    public void remove() throws Exception {
    }

    @Test
    public void insertOrUpdate() throws Exception {
        bplusTree = new BplusTree(6);
        bplusTree.insertOrUpdate(123, "jeson");
    }

}