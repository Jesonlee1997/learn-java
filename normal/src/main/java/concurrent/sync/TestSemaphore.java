package concurrent.sync;

import java.util.concurrent.Semaphore;

/**
 * Created by JesonLee
 * on 2017/5/3.
 */
public class TestSemaphore {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(10);
        semaphore.acquire();//获得一个信号量
        semaphore.release();//释放自己的信号量
    }
}
