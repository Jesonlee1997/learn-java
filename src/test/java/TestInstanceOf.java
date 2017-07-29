import org.junit.Test;
import 数据结构.btree.BTree;

import java.util.Map;

/**
 * 测试instanceOf的效率
 * Created by lijs
 * on 2017/7/12.
 */
public class TestInstanceOf {
    @Test
    public void test1() {
        long start = System.currentTimeMillis();

        BTree s = new BTree();
        for (int i = 0; i < 10000 * 10000; i++) {
            if (s instanceof Map) {
                //do something
            }
        }

        System.out.print(System.currentTimeMillis() - start);
    }

    @Test
    public void test2() {
        long start = System.currentTimeMillis();

        BTree s = new BTree();
        for (int i = 0; i < 10000 * 10000; i++) {
            if (s.getClass().equals(Map.class)) {
                //do something
            }
        }

        System.out.print(System.currentTimeMillis() - start);
    }
}
