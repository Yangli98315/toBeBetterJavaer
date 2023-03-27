package com.calove.demo.redis.common;

import com.calove.framework.redis.core.RedisKeyDefine;

import java.time.Duration;

/**
 * Redis Key 常量
 *
 * @author calove
 */
public interface RedisKeyConstants {
    String USER_KEY_TEMPLATE = "user:%";
    RedisKeyDefine USER = new RedisKeyDefine(RedisKeyDefine.RedisTypeEnum.STRING, USER_KEY_TEMPLATE,
            RedisKeyDefine.TimeoutTypeEnum.DYNAMIC, Duration.ofDays(1), "用户信息");
}
