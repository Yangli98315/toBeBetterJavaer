package com.calove.demo.redis.service.impl;

import com.calove.demo.redis.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class UserServiceImplTest {


    @Autowired
    private UserServiceImpl userService;

    @Test
    void save() {
        userService.saveOrUpdate(User.builder()
                .userId(UUID.randomUUID().toString())
                .address("长沙")
                .userName("calove")
                .registerTime(LocalDateTime.now())
                .build());
    }

    @Test
    void getUserByUserId() {
        User user = User.builder()
                .userId(UUID.randomUUID().toString())
                .address("长沙")
                .userName("calove")
                .registerTime(LocalDateTime.now())
                .build();
        userService.saveOrUpdate(user);
        userService.getUserByUserId(user.getUserId());
    }

    @Test
    void delByUserId() {
        User user = User.builder()
                .userId(UUID.randomUUID().toString())
                .address("长沙")
                .userName("calove")
                .registerTime(LocalDateTime.now())
                .build();
        userService.saveOrUpdate(user);
        userService.delByUserId(user.getUserId());
    }
}