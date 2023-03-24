package com.calove.rocketmq.learning.model;

import java.io.Serializable;

/**
 * 消息父类
 *
 * @author calove
 */
public abstract class AbstractMQ implements Serializable {

    /**
     * 获取消息主题名称
     *
     * @return
     */
    public abstract String getMQName();

    /**
     * 转成JSON格式消息
     * @return
     */
    public abstract String toMessage();

}
