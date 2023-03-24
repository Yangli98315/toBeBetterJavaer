package com.calove.springboot.learn.set;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "person")
@Data
public class Person {
    private String[] foods;
    private List<String> foodList;
}
