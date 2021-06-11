package com.kingwarluo.warehouseservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayTestController {

    @GetMapping("/list")
    public String list() {
        return "list";
    }

    @GetMapping("/single")
    public String single() {
        return "single";
    }

}
