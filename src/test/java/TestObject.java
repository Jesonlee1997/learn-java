import org.junit.Test;

/**
 * Created by JesonLee
 * on 2017/8/7.
 */
public class TestObject {
    @Test
    public void test1() {
        char[][] ints = new char[1024 * 1024 * 7][];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = new char[0];
        }
        System.out.println();
    }

    @Test
    public void test2() {
        Long[] longs = new Long[7 * 1000 * 1000];
        for (int i = 0; i < longs.length; i++) {
            longs[i] = new Long(i);
        }
        System.out.println(longs);
    }

    @Test
    public void test3() {
        String s = "？";
        System.out.println(s.length());
    }
}
