package com.calove.framework.redis.core;

import java.util.ArrayList;
import java.util.List;

/**
 * redis Key 注册表
 *
 * @author calove
 */
public final class RedisKeyRegister {
    /**
     * redis Key 注册表
     */
    private static final List<RedisKeyDefine> REDIS_KEY_DEFINE_LIST = new ArrayList<>();

    /**
     * 注册redis Key
     *
     * @param redisKeyDefine redisKey
     */
    public static void add(RedisKeyDefine redisKeyDefine) {
        REDIS_KEY_DEFINE_LIST.add(redisKeyDefine);
    }

    public static List<RedisKeyDefine> list() {
        return REDIS_KEY_DEFINE_LIST;
    }

    public static int size() {
        return REDIS_KEY_DEFINE_LIST.size();
    }
}
