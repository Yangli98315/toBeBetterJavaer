package com.calove.springboot.learn.set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationDemo {

    @Bean
    public Person person() {
        return new Person();
    }
}
