package com.kingwarluo.warehouseservice.dubbo;

import com.kingwarluo.warehouseservice.dto.Stock;

/**
 * 仓存服务
 *
 * @author jianhua.luo
 * @date 2021/5/8
 */
public interface WarehouseService {

    /**
     * 获取库存
     *
     * @author jianhua.luo
     * @date 2021/5/8
     */
    Stock getStock(Long skuId);

}
