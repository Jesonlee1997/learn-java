import org.junit.Test;
import sun.misc.Unsafe;
import unsafe.MyUnsafe;

/**
 * @author JesonLee
 * @date 2017/11/5.
 */
public class TestCAS {
    @Test
    public void test1() {
        int count = 1000 * 1000;
        Unsafe unsafe = MyUnsafe.getUnsafe();
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            //unsafe.compareAndSwapInt()
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}
