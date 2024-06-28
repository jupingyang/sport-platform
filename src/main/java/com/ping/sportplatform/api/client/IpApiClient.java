package com.ping.sportplatform.api.client;

import com.ping.sportplatform.api.response.IpApiResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.Map;

@Component
public class IpApiClient {
    private RestTemplate restTemplate;

    @PostConstruct
    private void init(){
        restTemplate = new RestTemplateBuilder()
                .rootUri("https://ipapi.co")
                .setConnectTimeout(Duration.ofSeconds(20))
                .build();
    }

    public IpApiResponse getIpInfo(String ipAddress){
        return restTemplate.getForObject(
                "/{ip}/json",
                IpApiResponse.class,
                Map.of("ip", ipAddress)
        );
    }
}
