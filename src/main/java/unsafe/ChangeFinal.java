package unsafe;

import sun.misc.Unsafe;

/**
 * Created by lijs
 * on 2017/8/8.
 */
public class ChangeFinal {
    public final int INDEX = 123;


    public static void main(String[] args) throws NoSuchFieldException {
        ChangeFinal changeFinal = new ChangeFinal();
        System.out.println(changeFinal.INDEX);

        Unsafe unsafe = MyUnsafe.getUnsafe();
        unsafe.putInt(changeFinal, unsafe.objectFieldOffset(ChangeFinal.class.getDeclaredField("INDEX")), 134);
        System.out.println(changeFinal.INDEX);
    }
}
