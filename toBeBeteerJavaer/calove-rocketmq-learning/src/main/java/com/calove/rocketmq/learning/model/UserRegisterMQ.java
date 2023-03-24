package com.calove.rocketmq.learning.model;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.calove.rocketmq.learning.core.MQConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户注册MQ
 * 用户注册后，需发送短信等异步
 *
 * @author calove
 */
@Data
public class UserRegisterMQ extends AbstractMQ {

    /**
     * 内置msg 消息体定义
     **/
    private MsgPayload payload;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class MsgPayload {
        /**
         * 用户手机号
         */
        private String phoneNumber;
        /**
         * 用户名
         */
        private String userName;

        /**
         * 用户编码
         */
        private String userId;
    }

    @Override
    public String getMQName() {
        return MQConstants.USER_REGISTER.getName();
    }

    @Override
    public String toMessage() {
        return JSONUtil.toJsonStr(payload);
    }

    public static UserRegisterMQ build(UserRegisterMQ.MsgPayload msgPayload) {
        UserRegisterMQ userRegisterMQ = new UserRegisterMQ();
        userRegisterMQ.setPayload(msgPayload);
        return userRegisterMQ;
    }

    /**
     * 解析MQ消息， 一般用于接收MQ消息时
     **/
    public static MsgPayload parse(String msg) {
        return JSON.parseObject(msg, MsgPayload.class);
    }

    /**
     * 定义 IMQReceiver 接口： 项目实现该接口则可接收到对应的业务消息
     **/
    public interface IMQReceiver {
        void receive(MsgPayload payload);
    }
}
