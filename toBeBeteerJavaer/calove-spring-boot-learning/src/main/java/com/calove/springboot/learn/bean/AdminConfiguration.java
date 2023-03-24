package com.calove.springboot.learn.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author calove
 */

@Configuration
public class AdminConfiguration {

    @Bean
    public AdminUser adminUser() {
        return new AdminUser("calove", 24);
    }


}
