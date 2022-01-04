package com.kingwarluo.orderservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

// @RefreshScope 则用于监听，当 Nacos 推送新的配置后，由这个注解负责接收并为属性重新赋值。
@RefreshScope
@Configuration
public class CustomConfig {

    @Value("${custom.flag}")
    private String flag;

    @Value("${custom.database}")
    private String database;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }
}
