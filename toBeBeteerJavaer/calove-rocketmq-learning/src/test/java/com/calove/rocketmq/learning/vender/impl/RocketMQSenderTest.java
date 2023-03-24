package com.calove.rocketmq.learning.vender.impl;

import com.calove.rocketmq.learning.model.UserRegisterMQ;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RocketMQSenderTest {

    @Autowired
    RocketMQSender rocketMQSender;

    @Test
    public void send() {
        UserRegisterMQ.MsgPayload payload = UserRegisterMQ.MsgPayload.builder()
                .phoneNumber("17380120614")
                .userName("calove")
                .userId("user10707401741")
                .build();
        UserRegisterMQ userRegisterMQ = UserRegisterMQ.build(payload);
        rocketMQSender.send(userRegisterMQ);
    }

    @Test
    public void sendOrderly() {

        for (int i = 0; i < 100; i++) {
            UserRegisterMQ.MsgPayload payload = UserRegisterMQ.MsgPayload.builder()
                    .phoneNumber("17380120614131")
                    .userName(UUID.randomUUID().toString())
                    .userId("user10707401741")
                    .build();
            UserRegisterMQ userRegisterMQ = UserRegisterMQ.build(payload);
            rocketMQSender.sendOrderly(userRegisterMQ, userRegisterMQ.getPayload().getUserId());
        }

    }
}