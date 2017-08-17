package concurrent.sync;

import java.util.concurrent.*;

/**
 * Created by JesonLee
 * on 2017/5/3.
 */
public class TestFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> future = executor.submit(new Task());

        executor.shutdown();
        System.out.println(future.get());

    }

    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            Thread.sleep(1000);
            System.out.println("子线程正在计算");
            TimeUnit.SECONDS.sleep(3);
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                sum += i;
            }
            return sum;
        }
    }
}
