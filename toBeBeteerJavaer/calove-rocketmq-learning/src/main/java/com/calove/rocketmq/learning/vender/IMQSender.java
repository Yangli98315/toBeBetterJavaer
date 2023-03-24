package com.calove.rocketmq.learning.vender;

import com.calove.rocketmq.learning.model.AbstractMQ;

/**
 * @author calove
 */
public interface IMQSender {
    /**
     * 发送消息
     *
     * @param abstractMQ 消息内容
     */
    void send(AbstractMQ abstractMQ);

    /**
     * 发送延迟消息
     *
     * @param abstractMQ 消息
     * @param delay      延迟档次
     */
    void send(AbstractMQ abstractMQ, int delay);

    /**
     * 发送顺序消息
     *
     * @param abstractMQ 消息
     * @param hashKey    哈希key 用于hash 散列到队列上
     */
    void sendOrderly(AbstractMQ abstractMQ, String hashKey);

    /**
     * 发送顺序消息
     *
     * @param abstractMQ 消息
     * @param hashKey    哈希key 用于hash 散列到队列上
     * @param timeOut    超时时间
     */
    void sendOrderly(AbstractMQ abstractMQ, String hashKey, int timeOut);


}
