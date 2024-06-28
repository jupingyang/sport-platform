package com.ping.sportplatform.api.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EdamamApiService {
    @ConfigurationProperties("edamam")
    @Bean
    public EdamamApiComponent edamamApiComponent(){
        return new EdamamApiComponent();
    }
}
