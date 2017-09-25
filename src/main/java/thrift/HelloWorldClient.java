package thrift;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import thrift.info.HelloWorldService;
import thrift.info.Request;
import thrift.info.RequestType;

/**
 * Created by lijs
 * on 2017/9/6.
 */
public class HelloWorldClient {
    public static void main(String[] args) throws Exception {
        TTransport transport = new TSocket("localhost", 7912);
        TProtocol protocol = new TBinaryProtocol(transport);

        // 创建client
        HelloWorldService.Client client = new HelloWorldService.Client(protocol);

        transport.open();  // 建立连接

        // 第一种请求类型
        Request request = new Request()
                .setType(RequestType.SAY_HELLO).setName("winwill2012").setAge(24);
        System.out.println(client.doAction(request));

        // 第二种请求类型
        request.setType(RequestType.QUERY_TIME).setName("winwill2012");
        System.out.println(client.doAction(request));

        transport.close();  // 请求结束，断开连接
    }

}
