package concurrent.sync;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by JesonLee
 * on 2017/5/14.
 */
public class TestBlockQueue {
    public static void main(String[] args) {
        BlockingDeque<String> blockingDeque = new LinkedBlockingDeque<>(1);
        ArrayBlockingQueue<Object> arrayBlockingQueue = new ArrayBlockingQueue<>(1, true);
        Thread thread1 = new Thread(() -> {
            while (true) {
                String first = null;
                try {
                    first = blockingDeque.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(first);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                blockingDeque.add("i="+i);

            }
        });
        thread1.start();
        thread2.start();
    }
}
