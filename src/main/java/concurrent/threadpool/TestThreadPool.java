package concurrent.threadpool;

import org.junit.Test;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by JesonLee
 * on 2017/5/17.
 */
public class TestThreadPool {

    private int taskNum = 100000;

    /**
     * 测试JDK自带的线程池，内部使用阻塞队列使用
     */
    @Test
    public void test1() {
        long start = System.currentTimeMillis();
        ThreadPoolExecutor executor = new
                ThreadPoolExecutor(10, 20, 60,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>());

        for (int i = 0; i < taskNum; i++) {
            executor.execute(new ComputeTask());
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    @Test
    public void test2() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < taskNum; i++) {
            new Thread(new ComputeTask()).start();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    @Test
    public void test3() {
        long start = System.currentTimeMillis();
        MyThreadPool threadPool = new MyThreadPool(2, 5);
        for (int i = 0; i < taskNum; i++) {
            threadPool.execute(new ComputeTask());
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    class ComputeTask implements Runnable {
        @Override
        public void run() {
            int sum = 0;
            for (int i = 0; i < 1000; i++) {
                sum += i;
            }
        }
    }
}
