package concurrent.sync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * exchanger
 * Created by JesonLee
 * on 2017/5/3.
 */
public class TestExchanger {
    public static void main(String[] args) {
        final Exchanger<List<Integer>> exchanger = new Exchanger<>();
        new Thread(() -> {
            List<Integer> list = new ArrayList<>(2);
            list.add(1);
            list.add(2);
            try {
                list = exchanger.exchange(list);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread1"+list);
        }).start();
        new Thread(() -> {
            List<Integer> list = new ArrayList<>(2);
            list.add(4);
            list.add(5);
            try {
                list = exchanger.exchange(list);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread2"+list);
        }).start();
    }
}
