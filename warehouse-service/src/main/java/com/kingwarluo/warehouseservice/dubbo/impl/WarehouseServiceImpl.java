package com.kingwarluo.warehouseservice.dubbo.impl;

import com.kingwarluo.warehouseservice.dto.Stock;
import com.kingwarluo.warehouseservice.dubbo.WarehouseService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class WarehouseServiceImpl implements WarehouseService {

    @Override
    public Stock getStock(Long skuId) {
        Stock stock = null;
        if(skuId == 1101L){
            //模拟有库存商品
            stock = new Stock(1101L, "Apple iPhone 11 128GB 紫色", 32, "台", "Apple 11 紫色版对应商品描述");
        }else if(skuId == 1102L){
            //模拟无库存商品
            stock = new Stock(1102L, "Apple iPhone 11 256GB 白色", 0, "台", "Apple 11 白色版对应商品描述");
        }else{
            //演示案例，暂不考虑无对应skuId的情况
        }
        return stock;
    }

}
