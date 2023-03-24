package com.calove.rocketmq.learning.consumer;

import cn.hutool.json.JSONUtil;
import com.calove.rocketmq.learning.model.UserRegisterMQ;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author calove
 */
//@RocketMQMessageListener(topic = "USER-REGISTER", consumerGroup = "USER-REGISTER")
@Slf4j
@Component
public class UserRegisterConsumer implements UserRegisterMQ.IMQReceiver, RocketMQListener<String> {
    @Override
    public void receive(UserRegisterMQ.MsgPayload payload) {
        log.info("开始USER-REGISTER消费,消费信息{}", JSONUtil.toJsonStr(payload));
    }

    @Override
    public void onMessage(String message) {
        receive(UserRegisterMQ.parse(message));
    }
}
