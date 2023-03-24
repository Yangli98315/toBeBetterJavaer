package com.calove.rocketmq.learning.core;

import com.calove.rocketmq.learning.core.MQRegistry;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * 消息定义
 *
 * @author calove
 */

@Data
public class MQDefine {

    private final String name;
    private final MQType mqType;

    @Getter
    @AllArgsConstructor
    public enum MQType {
        DELAY,
        NORMAL;
    }

    public MQDefine(String name, MQType mqType) {
        this.name = name;
        this.mqType = mqType;
        MQRegistry.add(this);
    }
}
