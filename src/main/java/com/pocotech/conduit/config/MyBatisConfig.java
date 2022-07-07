package com.pocotech.conduit.config;

import com.pocotech.conduit.repository.UUIDTypeHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisConfig {

    @Bean
    public UUIDTypeHandler uuidTypeHandler() {
        return new UUIDTypeHandler();
    }

}
