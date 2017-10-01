package concurrent.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by JesonLee
 * on 2017/5/17.
 */
public class MyThreadPool {
    private int corePoolSize = 2;
    private int maxPoolSize = 5;
    private int backlog = 1000;
    private List<Thread> workerList = new ArrayList<>();
    private BlockingQueue<Runnable> blockingQueue = new LinkedBlockingDeque<>();

    public MyThreadPool(int corePoolSize, int maxPoolSize) {
        this.corePoolSize = corePoolSize;
        this.maxPoolSize = maxPoolSize;
    }

    private Lock lock = new ReentrantLock();


    public void execute(Runnable task) {
        if (workerList.size() < maxPoolSize) {
            Worker worker = new Worker();
            workerList.add(worker);
            worker.start();
        }
        try {
            blockingQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public class Worker extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Runnable task = blockingQueue.take();
                    task.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        MyThreadPool myThreadPool = new MyThreadPool(2, 5);

        for (int i = 0; i < 1000; i++) {
            myThreadPool.execute(() -> System.out.println(Thread.currentThread().getName()));
        }

    }
}
