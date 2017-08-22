package socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * Created by JesonLee
 * on 2017/8/16.
 */
public class TestSocket {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("www.baidu.com", 80);
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[512];
        inputStream.read(bytes);
        System.out.println(new String(bytes));
    }
}
