package com.calove.demo.redis.service.impl;

import com.calove.demo.redis.common.RedisKeyConstants;
import com.calove.demo.redis.entity.User;
import com.calove.demo.redis.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author calove
 */
@Service
@Slf4j
public class UserServiceImpl implements IUserService {
    @Override
    @CachePut(cacheNames = RedisKeyConstants.USER_KEY_TEMPLATE, key = "#user.userId")
    public User saveOrUpdate(User user) {
        log.info("保存用户：{}信息", user.getUserId());
        return user;
    }

    @Override
    @Cacheable(cacheNames = RedisKeyConstants.USER_KEY_TEMPLATE, key = "#userId")
    public User getUserByUserId(String userId) {
        log.info("获取用户：{}信息", userId);
        return new User();
    }

    @Override
    @CacheEvict(cacheNames = RedisKeyConstants.USER_KEY_TEMPLATE, key = "#userId")
    public void delByUserId(String userId) {
        log.info("删除用户：{}信息", userId);
    }
}
