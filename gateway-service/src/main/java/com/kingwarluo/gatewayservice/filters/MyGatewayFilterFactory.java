package com.kingwarluo.gatewayservice.filters;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 * 命名有要求
 * My（自定义，用于配置文件）GatewayFilterFactory（固定写法）
 *
 * @author kingwarluo
 * @date 2022/1/6 14:04
 */
@Component
public class MyGatewayFilterFactory extends AbstractGatewayFilterFactory<MyGatewayFilterFactory.Config> {

    private static final String MY_FILTER_NAME = "myFilterName";

    public MyGatewayFilterFactory() {
        super(Config.class);
    }

    /**
     * shortcutFieldOrder可参考这个，配合{@see ShortcutType}使用，将数据绑定成某种格式后，赋值给Configurable接口类的泛型上，即Config类上
     * https://blog.csdn.net/he702170585/article/details/107335529?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522164145090216780265456154%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=164145090216780265456154&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduend~default-1-107335529.first_rank_v2_pc_rank_v29&utm_term=shortcutFieldOrder%E4%BD%9C%E7%94%A8&spm=1018.2226.3001.4187
     * 如下：未设置ShortcutType默认为default
     * @return
     */
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(MY_FILTER_NAME);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                ServerHttpRequest request = exchange.getRequest();
                System.out.println(config.getMyFilterName());
                String name = request.getQueryParams().getFirst(config.getMyFilterName());
                if(StringUtils.isNotEmpty(name)) {
                    System.out.println(String.format("局部过滤器拦截，skuName=%s", name));
                }
                // 放行所有请求
                return chain.filter(exchange);
            }
        };
    }

    public static class Config {

        private String myFilterName;

        public String getMyFilterName() {
            return myFilterName;
        }

        public void setMyFilterName(String myFilterName) {
            this.myFilterName = myFilterName;
        }
    }
}
