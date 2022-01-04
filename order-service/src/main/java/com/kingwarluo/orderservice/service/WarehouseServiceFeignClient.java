package com.kingwarluo.orderservice.service;

import com.kingwarluo.orderservice.dto.Stock;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author kingwarluo
 * @{description}
 * @date 2021/12/29 14:43
 */
@FeignClient("warehouse-service")
public interface WarehouseServiceFeignClient {

    @GetMapping("/stock")
    public Stock getStock(@RequestParam("skuId") Long skuId);

}
