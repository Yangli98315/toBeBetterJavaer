package com.calove.springboot.learn.set;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.stream.Collectors;


@RunWith(SpringRunner.class)
@SpringBootTest()
public class ConfigurationDemoTest {

    @Autowired
    Person person;
    @org.junit.Test
    public void person() {
        System.out.println(Arrays.toString(person.getFoods()));
        System.out.println(person.getFoodList().stream().collect(Collectors.joining(",")));
    }
}