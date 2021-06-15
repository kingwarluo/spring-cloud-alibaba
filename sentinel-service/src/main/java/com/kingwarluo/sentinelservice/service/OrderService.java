package com.kingwarluo.sentinelservice.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @SentinelResource(value = "createOrder", blockHandler = "createOrderException")
    public void createOrder() throws IllegalStateException {
        try {
            Thread.sleep(101);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("订单创建成功！");
    }

    /**
     * 异常处理
     * 方法返回值、访问修饰符、抛出异常要与原始的 createOrder 方法完全相同
     *
     * @author jianhua.luo
     * @date 2021/6/15
     */
    public void createOrderException(BlockException e) {
        String msg = null;
        if(e instanceof FlowException){//限流异常
            msg = "资源已被限流";
        }else if(e instanceof DegradeException){//熔断异常
            msg = "资源已被熔断,请稍后再试";
        }else if(e instanceof ParamFlowException){ //热点参数限流
            msg = "热点参数限流";
        }else if(e instanceof SystemBlockException){ //系统规则异常
            msg = "系统规则(负载/....不满足要求)";
        }else if(e instanceof AuthorityException){ //授权规则异常
            msg = "授权规则不通过";
        }
        throw new IllegalStateException(msg);
    }

}
