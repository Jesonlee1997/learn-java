package concurrent.sync;

/**
 * 使用一个小型对象作为锁来达到同步的目的
 * 也可以使用Condition
 * Created by JesonLee
 * on 2017/5/3.
 */
public class TestWait {
    private static final byte[] bytes = new byte[0];
    public void testWait(){
        new Thread(() -> {
            synchronized (bytes) {
                try {
                    bytes.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public void testNotify() throws InterruptedException {
        new Thread(() -> {
            synchronized (bytes) {
                bytes.notify();
            }
        }).start();
    }

    public static void main(String[] args) throws InterruptedException {
        TestWait testWait = new TestWait();
        testWait.testWait();
        testWait.testNotify();
    }
}
