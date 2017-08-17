package unsafe;

import sun.misc.Unsafe;

/**
 * Created by lijs
 * on 2017/8/8.
 */
public class DirectMemory {
    private static final Unsafe UNSAFE = MyUnsafe.getUnsafe();

    private long size;
    private long offset;
    private long putIndex;
    private long getIndex;

    public DirectMemory(long size) {
        this.size = size;
        offset = UNSAFE.allocateMemory(size);
        putIndex = offset;
        getIndex = offset;
    }

    public void putInt(int i) {
        UNSAFE.putInt(putIndex, i);
        putIndex += 4;
    }

    public int getInt(long index) {
        int i = UNSAFE.getInt(index + getIndex);
        getIndex += 4;
        return i;
    }

    public int getInt() {
        int i = UNSAFE.getInt(getIndex);
        getIndex += 4;
        return i;
    }
}
