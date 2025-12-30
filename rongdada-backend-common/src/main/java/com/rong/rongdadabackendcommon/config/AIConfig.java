package com.rong.rongdadabackendcommon.config;

import com.zhipu.oapi.ClientV4;
import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "ai")
@ConditionalOnProperty(prefix = "ai",name = "apiKey")
@Data
public class AIConfig {
    /**
     * apiKey
     */
    private String apiKey;

    @Bean
    public ClientV4 clientV4(){
        return new ClientV4.Builder(apiKey).build();
    }
}
