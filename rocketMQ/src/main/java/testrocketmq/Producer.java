package testrocketmq;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;

/**
 * Created by JesonLee
 * on 2017/4/22.
 */
public class Producer {
    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        //创建一个producer
        DefaultMQProducer producer = new DefaultMQProducer("group1");
        producer.setNamesrvAddr("192.168.56.100:9876");
        producer.start();

        for (int i = 0; i < 100; i++) {
            Message message = new Message("orders1", ("order1" + i).getBytes());

            SendResult result = producer.send(message);
            System.out.println(result);
            System.out.println(message + "send out");
            Thread.sleep(500);
        }
        producer.shutdown();
    }
}
