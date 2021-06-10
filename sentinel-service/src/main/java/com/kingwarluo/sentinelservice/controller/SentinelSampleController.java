package com.kingwarluo.sentinelservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentinelSampleController {

    @GetMapping("/test_flow_rule")
    public String testFlowRule(){
        return "SUCCESS";
    }

}
