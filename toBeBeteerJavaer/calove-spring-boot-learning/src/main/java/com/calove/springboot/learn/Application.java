package com.calove.springboot.learn;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 基本使用：@ComponentScan注解可以放在任何一个Spring容器类上，
 * 比如@ConfigurationDemo、@SpringBootApplication等注解上。
 * 1. 在使用@ComponentScan注解时，需要指定需要扫描的包名
 * 2. 使用通配符：@ComponentScan注解支持使用通配符来扫描多个包
 * 3. 指定类：@ComponentScan注解还可以通过basePackageClasses属性来指定需要扫描的类
 * 4. 排除类：@ComponentScan注解支持使用excludeFilters属性来排除某些类
 * 5. 自定义过滤规则：@ComponentScan注解支持使用includeFilters和excludeFilters属性来自定义过滤规则
 */
//@ComponentScan(basePackages = {"com.calove.springboot.learn.bean","com.calove.springboot.learn.*"},
//        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Address.class)},
//        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Address.class)}
//        ,basePackageClasses = {Address.class})
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
