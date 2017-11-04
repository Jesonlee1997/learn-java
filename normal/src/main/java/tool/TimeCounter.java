package tool;

/**
 * @author JesonLee
 * @date 2017/11/4.
 */
public class TimeCounter {
    private long startTime;
    private long endTime;

    public static TimeCounter start() {
        TimeCounter counter = new TimeCounter();
        counter.startTime = System.currentTimeMillis();
        return counter;
    }

    public void end(String msg) {
        endTime = System.currentTimeMillis();
        System.out.printf("%s cost: %d", msg, endTime - startTime);
    }

    public void end() {
        endTime = System.currentTimeMillis();
        System.out.printf("cost: %dms\n", endTime - startTime);

    }
}
