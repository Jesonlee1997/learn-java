package concurrent.sync;

/**
 * Created by JesonLee
 * on 2017/5/3.
 */
public class Demo {
    static int count;
    public synchronized static void foo1() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }
    public synchronized static void foo2() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }
}
