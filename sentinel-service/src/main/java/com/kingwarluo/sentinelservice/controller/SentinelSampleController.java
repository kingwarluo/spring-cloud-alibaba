package com.kingwarluo.sentinelservice.controller;

import com.kingwarluo.sentinelservice.service.OrderService;
import com.kingwarluo.sentinelservice.vo.ResponseObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SentinelSampleController {

    @Resource
    private OrderService orderService;

    @GetMapping("/test_flow_rule")
    public ResponseObject testFlowRule(){
        return new ResponseObject("0", "SUCCESS");
    }

    /**
     * 测试服务的熔断降级
     *
     * @author jianhua.luo
     * @date 2021/6/15
     */
    @GetMapping("/test_service_histrix")
    public ResponseObject testServiceHistrix(){
        try {
            orderService.createOrder();
        } catch (IllegalStateException e) {
            return new ResponseObject("1", e.getMessage());
        }
        return new ResponseObject("0", "SUCCESS");
    }

}
