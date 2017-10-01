package tool.varint;

import java.nio.ByteBuffer;

/**
 * Created by lijs
 * on 2017/8/15.
 */
public class ConvertVarInt {
    public static void putVarInt(ByteBuffer buf, int val) {
        int count = 4 * 7;
        while (count > 0) {
            count -= 7;
            byte tmp = (byte) (val >> count);
            if (count == 0) tmp |= (1<<7);
            buf.put(tmp);
            val &= (1<<count) - 1;
        }
    }

    public static int getVarInt(ByteBuffer buf) {
        int ret = 0;
        while (true) {
            byte tmp = buf.get();
            ret = ret << 7 | (tmp & ((1<<7) - 1));
            if ((tmp & (1<<7)) != 0) {
                break;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(8);
        putVarInt(buffer, 16);
        System.out.println();

    }
}
