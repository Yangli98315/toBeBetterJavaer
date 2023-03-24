package com.calove.springboot.learn.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author calove
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminUser {
    private String name;
    private Integer age;
}
