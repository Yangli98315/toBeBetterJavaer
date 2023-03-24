package com.calove.rocketmq.learning.vender.impl;

import com.calove.rocketmq.learning.model.AbstractMQ;
import com.calove.rocketmq.learning.vender.IMQSender;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * rocketMq 生产者
 *
 * @author calove
 */

@Component
public class RocketMQSender implements IMQSender {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    private static final List<Integer> DELAY_TIME_LEVEL = new ArrayList<>();

    static {
        // 预设值的延迟时间间隔为：1s、 5s、 10s、 30s、 1m、 2m、 3m、 4m、 5m、 6m、 7m、 8m、 9m、 10m、 20m、 30m、 1h、 2h
        DELAY_TIME_LEVEL.add(1);
        DELAY_TIME_LEVEL.add(5);
        DELAY_TIME_LEVEL.add(10);
        DELAY_TIME_LEVEL.add(30);
        DELAY_TIME_LEVEL.add(60 * 1);
        DELAY_TIME_LEVEL.add(60 * 2);
        DELAY_TIME_LEVEL.add(60 * 3);
        DELAY_TIME_LEVEL.add(60 * 4);
        DELAY_TIME_LEVEL.add(60 * 5);
        DELAY_TIME_LEVEL.add(60 * 6);
        DELAY_TIME_LEVEL.add(60 * 7);
        DELAY_TIME_LEVEL.add(60 * 8);
        DELAY_TIME_LEVEL.add(60 * 9);
        DELAY_TIME_LEVEL.add(60 * 10);
        DELAY_TIME_LEVEL.add(60 * 20);
        DELAY_TIME_LEVEL.add(60 * 30);
        DELAY_TIME_LEVEL.add(60 * 60 * 1);
        DELAY_TIME_LEVEL.add(60 * 60 * 2);
    }


    @Override
    public void send(AbstractMQ abstractMQ) {
        SendResult sendResult = rocketMQTemplate.syncSend(abstractMQ.getMQName(), abstractMQ.toMessage());
    }

    @Override
    public void send(AbstractMQ abstractMQ, int delay) {
        rocketMQTemplate.syncSend(abstractMQ.getMQName(),
                MessageBuilder.withPayload(abstractMQ.toMessage()).build(),
                300000,
                getNearDelayLevel(delay));
    }

    @Override
    public void sendOrderly(AbstractMQ abstractMQ, String hashKey) {
        rocketMQTemplate.syncSendOrderly(abstractMQ.getMQName(), abstractMQ.toMessage(), hashKey);
    }

    @Override
    public void sendOrderly(AbstractMQ abstractMQ, String hashKey, int timeOut) {
        SendResult sendResult = rocketMQTemplate.syncSendOrderly(abstractMQ.getMQName(),
                abstractMQ.toMessage(),
                hashKey,
                timeOut);

    }

    /**
     * 获取最接近的节点值
     **/
    private int getNearDelayLevel(int delay) {

        // 如果包含则直接返回
        if (DELAY_TIME_LEVEL.contains(delay)) {
            return DELAY_TIME_LEVEL.indexOf(delay) + 1;
        }

        //两个时间的绝对值 - 位置
        TreeMap<Integer, Integer> resultMap = new TreeMap<>();
        DELAY_TIME_LEVEL.forEach(time -> resultMap.put(Math.abs(delay - time), DELAY_TIME_LEVEL.indexOf(time) + 1));
        return resultMap.firstEntry().getValue();
    }
}
