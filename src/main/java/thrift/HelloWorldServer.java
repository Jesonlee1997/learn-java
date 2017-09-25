package thrift;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import thrift.info.HelloWorldService;

import java.net.ServerSocket;

/**
 * Created by lijs
 * on 2017/9/6.
 */
public class HelloWorldServer {
    public static void main(String[] args) throws Exception {
        int port = 7912;
        ServerSocket socket = new ServerSocket(port);
        TServerSocket serverTransport = new TServerSocket(socket);
        HelloWorldService.Processor processor = new HelloWorldService.Processor(new HelloWorldServiceImpl());
        TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));
        System.out.println("Running server on " + port);
        server.serve();
    }

}
