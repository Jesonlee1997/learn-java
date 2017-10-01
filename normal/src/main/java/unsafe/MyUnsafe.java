package unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by lijs
 * on 2017/8/8.
 */
public class MyUnsafe {
    private static final Unsafe UNSAFE;

    static {
        Unsafe UNSAFE1;
        Field field = null;
        try {
            field = Unsafe.class.getDeclaredField("theUnsafe");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        assert field != null;
        field.setAccessible(true);

        try {
            UNSAFE1 = (Unsafe) field.get(Unsafe.class);
        } catch (IllegalAccessException e) {
            UNSAFE1 = null;
            e.printStackTrace();
        }
        UNSAFE = UNSAFE1;
    }

    public static Unsafe getUnsafe() {
        return UNSAFE;
    }

    public static void allocate(long size) {
        long memory = UNSAFE.allocateMemory(size);
        System.out.println(memory);
    }


    public static void main(String[] args) throws InstantiationException {
        DirectMemory directMemory = new DirectMemory(1024 * 1024 * 1024 * 6L);
        for (int i = 0; i < 10000; i++) {
            directMemory.putInt(i);
        }
        for (int i = 0; i < 10000; i++) {
            if (directMemory.getInt() != i) {
                System.out.println("error");
            }
        }
    }
}
