package concurrent.sync;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;

/**
 * Created by JesonLee
 * on 2017/6/2.
 */
public class TestLinkedQueue {
    private static Queue<String> tickets = new ConcurrentLinkedQueue<>();

    static {
        for (int i = 0; i < 1000000; i++) {
            tickets.add("票编号为" + i);
        }
    }

    private static CountDownLatch countDownLatch = new CountDownLatch(3);

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        new Thread(() -> {
            while (true) {
                String ticket = tickets.poll();
                if (ticket == null) {
                    countDownLatch.countDown();
                    break;
                }
                System.out.println(ticket);
            }
        }).start();
        new Thread(() -> {
            while (true) {
                String ticket = tickets.poll();
                if (ticket == null) {
                    countDownLatch.countDown();
                    break;
                }
                System.out.println(ticket);

            }
        }).start();
        new Thread(() -> {
            while (true) {
                String ticket = tickets.poll();
                if (ticket == null) {
                    countDownLatch.countDown();
                    break;
                }
                System.out.println(ticket);

            }
        }).start();
        countDownLatch.await();
        System.out.println("时间为：" + (System.currentTimeMillis() - start));
    }
}
