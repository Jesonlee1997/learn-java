package unsafe;

import sun.misc.Unsafe;

/**
 * Created by lijs
 * on 2017/8/8.
 */
public class AtomicCounter {
    private static final Unsafe UNSAFE = MyUnsafe.getUnsafe();
    private long offset;
    private volatile long counter = 0;

    public AtomicCounter() {
        try {
            offset = UNSAFE.objectFieldOffset(AtomicCounter.class.getDeclaredField("counter"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public AtomicCounter(long counter) {
        this.counter = counter;
        try {
            offset = UNSAFE.objectFieldOffset(AtomicCounter.class.getDeclaredField("counter"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public void increment() {
        long except = counter;
        while (!UNSAFE.compareAndSwapLong(this, offset, except, except + 1)) {
            except = counter;
        }
    }

    public long getCounter() {
        return this.counter;
    }

    public static void main(String[] args) {
        AtomicCounter counter = new AtomicCounter();
        counter.increment();
        System.out.println(counter.getCounter());
    }
}
