package concurrent.sync;

/**
 * Created by JesonLee
 * on 2017/6/1.
 */
public class PossibleReordering {
    static int x = 0, y = 0;
    static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; testReordering(i); i++) {

        }
        System.out.println("I am done");

    }

    public static boolean testReordering(int i) throws InterruptedException {
        Thread one = new Thread(() -> {
            a = 1;
            x = b;
        });

        Thread other = new Thread(() -> {
            b = 1;
            y = a;
        });
        one.start();
        other.start();
        one.join();
        other.join();
        System.out.println("第" + i + "次" + "运行的结果为" + "(" + x + "," + y + ")");
        if (x ==0 && y == 0) {
            return false;
        } else {
            x = 0;
            y = 0;
            return true;
        }
    }
}
