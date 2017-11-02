package testrocketmq;

import com.alibaba.rocketmq.client.consumer.DefaultMQPullConsumer;
import com.alibaba.rocketmq.client.consumer.MessageQueueListener;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.message.MessageQueue;

import java.util.Set;

/**
 * Created by JesonLee
 * on 2017/4/22.
 */
public class PullConsumer {
    public static void main(String[] args) throws MQClientException {
        DefaultMQPullConsumer consumer = new DefaultMQPullConsumer("consumergroup");
        consumer.setNamesrvAddr("192.168.56.100:9876");
        consumer.start();
        Set<MessageQueue> messageQueues = consumer.fetchSubscribeMessageQueues("orders");
        System.out.println(messageQueues.size());
        int i = 0;
        for (MessageQueue messageQueue : messageQueues) {
            System.out.println(messageQueue.getTopic());
        }
        //消息队列的监听
        consumer.registerMessageQueueListener("", new MessageQueueListener() {

            @Override
            //消息队列有改变，就会触发
            public void messageQueueChanged(String topic, Set<MessageQueue> mqAll,
                                            Set<MessageQueue> mqDivided) {
                // TODO Auto-generated method stub
            }
        });
    }
}
