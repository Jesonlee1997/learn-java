import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by JesonLee
 * on 2017/7/5.
 */
public class TestReentrantLock {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        new Thread(() -> {
            lock.lock();
            lock.unlock();
        }).start();
        Thread.sleep(1000);
        new Thread(() -> {
            lock.lock();
            lock.unlock();
        }).start();
    }
}
