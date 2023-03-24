package com.calove.springboot.learn.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * 此注解使用在Spring的组件类上。默认的，Spring中Bean的依赖一开始就被创建和配置。
 * 如果想要延迟初始化一个bean，那么可以在此类上使用Lazy注解，表示此bean只有在第一次被使用的时候才会被创建和初始化。
 * 此注解也可以使用在被@Configuration注解的类上，表示其中所有被@Bean注解的方法都会延迟初始化。
 * @Lazy注解只有在Bean被单例管理时才有效。
 * 如果Bean被其他作用域管理，比如原型或会话作用域，那么@Lazy注解将不起作用，Bean会在每次使用时都被重新创建
 */
@Service
@Lazy
public class AdminService {
}
