package com.calove.rocketmq.learning.core;

import java.util.ArrayList;
import java.util.List;

/**
 * 消息注册表
 *
 * @author calove
 */
public final class MQRegistry {
    private static final List<MQDefine> mqList = new ArrayList<>();

    public static void add(MQDefine mqDefine) {
        mqList.add(mqDefine);
    }

    public static List<MQDefine> list() {
        return mqList;
    }

}
