package concurrent.sync;

/**
 * Created by lijs
 * on 2017/8/29.
 */
public class TestThreadLocal {
    public static void main(String[] args) {
        ThreadLocal<String[]> local = ThreadLocal.withInitial(() -> new String[]{"1", "2", "3"});
        for (String s : local.get()) {
            System.out.println(s);
        }
    }
}
