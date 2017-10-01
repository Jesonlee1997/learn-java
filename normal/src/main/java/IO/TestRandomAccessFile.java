package IO;

import sun.misc.Unsafe;

import java.io.IOException;
import java.lang.reflect.Field;

/**
 * Created by JesonLee
 * on 2017/7/26.
 */
public class TestRandomAccessFile {
    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException {
        /*RandomAccessFile accessFile = new RandomAccessFile("","");
        accessFile.getFilePointer();*/
        Field theUnsafeInstance = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafeInstance.setAccessible(true);

        Unsafe unsafe = (Unsafe) theUnsafeInstance.get(Unsafe.class);

        System.out.println(unsafe.addressSize());
    }
}
