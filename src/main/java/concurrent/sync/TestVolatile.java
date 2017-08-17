package concurrent.sync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by JesonLee
 * on 2017/5/16.
 */
public class TestVolatile {

    private volatile List<Object> objectList = new ArrayList<>();

    public void add(Object o) {
        objectList.add(o);
    }

    public int size() {
        return objectList.size();
    }

    public static void main(String[] args) {
        TestVolatile testVolatile = new TestVolatile();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                testVolatile.add(new Object());
                System.out.println("add" + i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();

        new Thread(() -> {
            while (true) {
                if (testVolatile.size() == 5) {
                    break;
                }
            }
            System.out.println("t2 结束");
        }, "t2").start();
    }
}
