package concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by JesonLee
 * on 2017/6/4.
 */
public class TestExecutors {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 8; i++) {
            service.submit(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }
        System.out.println(service);
        service.shutdown();
        System.out.println(service.isShutdown());
        System.out.println(service.isTerminated());
        System.out.println(service);

        TimeUnit.SECONDS.sleep(3);
        System.out.println(service.isShutdown());
        System.out.println(service.isTerminated());
        System.out.println(service);


    }
}
