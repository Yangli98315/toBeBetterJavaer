package com.calove.nacos.config.controller;

import com.calove.nacos.config.bean.OrderProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class OrderController {

    @Autowired
    OrderProperties orderProperties;

    @RequestMapping(value = "/api/v1/ordercofing",method = RequestMethod.GET)
    public String orderConfig() {
        return orderProperties.toString();
    }

}
