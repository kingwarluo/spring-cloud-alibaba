package com.kingwarluo.orderservice.controller;

import com.kingwarluo.orderservice.config.CustomConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private CustomConfig customConfig;

    @GetMapping("/test")
    public String test() {
        return String.format("flag:%s<br/>database:%s", customConfig.getFlag(), customConfig.getDatabase());
    }

}
