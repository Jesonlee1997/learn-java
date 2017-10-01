package concurrent.sync;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 使用countDownLatch对数组进行排序
 * Created by JesonLee
 * on 2017/5/3.
 */
public class TestCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        int count = 10;
        int size = 100;
        CountDownLatch countDownLatch = new CountDownLatch(count);
        int[] datas = new int[size];
        Random random = new Random();
        int step = size / count;
        for (int i = 0; i < size; i++) {
            datas[i] = random.nextInt(1000);
        }
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                count,count, 60,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>(count));

        for (int i = 0; i < count; i++) {
            int start = i * step;
            int end = (i+1)*step;
            if (i == count - 1) {
                end = size;
            }
            threadPoolExecutor.execute(new MyRunnable(countDownLatch, datas, start, end));
        }
        countDownLatch.await();
        threadPoolExecutor.shutdown();
        threadPoolExecutor.awaitTermination(1L, TimeUnit.DAYS);
        for (int data : datas) {
            System.out.println(data);
        }
    }

    /**
     * MyRunnable负责对指定范围内的数据进行排序
     */
    private static class MyRunnable implements Runnable {
        private CountDownLatch latch;
        private int[] datas;
        private int start;
        private int end;

        public MyRunnable(CountDownLatch latch, int[] datas, int start, int end) {
            this.latch = latch;
            this.datas = datas;
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            for (int i = start+1; i < end; i++) {
                int key = datas[i];
                int j = i;
                while (j > start) {
                    if (datas[j-1] > key) {
                        datas[j] = datas[j-1];
                        j--;
                    } else {
                        break;
                    }
                }
                datas[j] = key;
            }
            latch.countDown();
        }
    }
}
