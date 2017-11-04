package zk;

import org.apache.zookeeper.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import tool.GetPath;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

/**
 * @Author lijs
 * @Create-time 2017/9/30.
 */
public class TestZooKeeper {
    private ZooKeeper zooKeeper;

    @Before
    @Test
    public void init() throws IOException, InterruptedException {
        //第一个参数是Zookeeper服务器列表

        Properties properties = new Properties();
        properties.load(GetPath.getResourceOf(TestZooKeeper.class, "/zk.properties"));
        String CONN = properties.getProperty("zookeeper");

        //第二个参数是Zookeeper，通讯的过期时长
        Integer sessionTimeOut = 5000;
        //第三个是watcher，监听连接上zookeeper后的事件
        //异步连接

        CountDownLatch latch = new CountDownLatch(1);
        zooKeeper = new ZooKeeper(CONN, sessionTimeOut, watchedEvent -> {
            if (watchedEvent.getState() == Watcher.Event.KeeperState.SyncConnected) {
                System.out.println("建立连接");
                latch.countDown();
            }
        });
        latch.await();
    }

    @Test
    public void testCreate() throws KeeperException, InterruptedException {
        //zooKeeper.delete("/app1/context1", -1);
        String s = zooKeeper.create("/app1",
                "127.0.0.1:8080".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT);
        System.out.println(s);
    }

    @Test
    public void testGetChildren() throws KeeperException, InterruptedException {
        List<String> children = zooKeeper.getChildren("/app1", false);
        System.out.println(children);
        for (String child : children) {
            System.out.println(child);
        }
    }

    @Test
    public void testDel() throws KeeperException, InterruptedException {
        zooKeeper.delete("/app1", -1);
    }

    @After
    public void close() {
        try {
            System.out.println("关闭zookeeper中");
            zooKeeper.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
