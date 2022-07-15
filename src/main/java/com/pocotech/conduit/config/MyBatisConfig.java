package com.pocotech.conduit.config;

import com.pocotech.conduit.repository.typehandler.URLTypeHandler;
import com.pocotech.conduit.repository.typehandler.UUIDTypeHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisConfig {

    @Bean
    public UUIDTypeHandler uuidTypeHandler() {
        return new UUIDTypeHandler();
    }

    @Bean
    public URLTypeHandler urlTypeHandler() {
        return new URLTypeHandler();
    }

}
