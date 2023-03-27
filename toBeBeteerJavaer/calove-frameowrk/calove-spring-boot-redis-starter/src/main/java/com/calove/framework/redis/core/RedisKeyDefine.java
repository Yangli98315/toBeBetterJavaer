package com.calove.framework.redis.core;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.Duration;

/**
 * reids 定义
 *
 * @author calove
 */

@Data
public class RedisKeyDefine {

    @AllArgsConstructor
    @Getter
    public enum RedisTypeEnum {
        STRING("String"),
        LIST("List"),
        HASH("Hash"),
        SET("Set"),
        ZSET("Sorted Set"),
        STREAM("Stream"),
        PUBSUB("Pub/Sub");

        /**
         * 类型
         */
        @JsonValue
        private final String type;
    }

    @Getter
    @AllArgsConstructor
    public enum TimeoutTypeEnum {

        FOREVER(1), // 永不超时
        DYNAMIC(2), // 动态超时
        FIXED(3); // 固定超时

        /**
         * 类型
         */
        @JsonValue
        private final Integer type;

    }


    /**
     * Key 类型的枚举
     */
    private final RedisTypeEnum redisType;
    /**
     * Key 模板
     */
    private final String keyTemplate;

    /**
     * 超时类型
     */
    private final TimeoutTypeEnum timeoutType;
    /**
     * 过期时间
     */
    private final Duration timeout;
    /**
     * 备注
     */
    private final String memo;

    /**
     * @param redisType   redisKeyType
     * @param keyTemplate 模板
     * @param timeoutType 超时类型
     * @param timeout     超时时间
     * @param memo        备注
     */
    public RedisKeyDefine(RedisTypeEnum redisType, String keyTemplate, TimeoutTypeEnum timeoutType, Duration timeout, String memo) {
        this.redisType = redisType;
        this.keyTemplate = keyTemplate;
        this.timeoutType = timeoutType;
        this.timeout = timeout;
        this.memo = memo;
        RedisKeyRegister.add(this);
    }

    /**
     * @param keyType     redisKeyType
     * @param keyTemplate 模板
     * @param timeout     超时时间
     * @param memo        备注
     */
    public RedisKeyDefine(RedisTypeEnum keyType, String keyTemplate, Duration timeout, String memo) {
        this(keyType, keyTemplate, TimeoutTypeEnum.FIXED, timeout, memo);
    }

    /**
     * @param keyType     redisKeyType
     * @param keyTemplate 模板
     * @param timeoutType 超时类型
     * @param memo        备注
     */
    public RedisKeyDefine(RedisTypeEnum keyType, String keyTemplate, TimeoutTypeEnum timeoutType, String memo) {
        this(keyType, keyTemplate, timeoutType, Duration.ZERO, memo);
    }

    public String formatKey(String key) {
        return String.format(this.keyTemplate, key);
    }
}
