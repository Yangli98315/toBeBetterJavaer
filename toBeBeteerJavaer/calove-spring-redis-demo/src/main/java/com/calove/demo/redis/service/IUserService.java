package com.calove.demo.redis.service;

import com.calove.demo.redis.entity.User;

/**
 * 用户服务
 *
 * @author calove
 */
public interface IUserService {
    User saveOrUpdate(User user);

    User getUserByUserId(String userId);

    void delByUserId(String userId);

}
