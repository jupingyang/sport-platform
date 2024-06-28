package com.ping.sportplatform.api.client;

import com.ping.sportplatform.api.response.EdamamApiResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.Map;

/**
 * java.lang.NullPointerException:
 * Cannot invoke "java.lang.Double.doubleValue()"
 * because the return value of "com.ping.sportplatform.api.response.EdamamApiResponse.getEnercKcal()" is null
 *
 */

@Component
public class EdamamApiClient1 {

    @Value("${edamam.appId}")
    private String appId; // app_id
    @Value("${edamam.appKey}")
    private String appKey; // app_key

    private RestTemplate restTemplate;

    @PostConstruct
    private void init(){
        restTemplate = new RestTemplateBuilder()
                .rootUri("https://api.edamam.com")
                .setConnectTimeout(Duration.ofSeconds(20))
                .build();
    }

    public EdamamApiResponse getFoodData(String food){
        var uriVariables = Map.of(
                "app_id", appId,
                "app_key", appKey,
                "food", food
        );

        return restTemplate.getForObject(
                "/api/food-database/v2/parser?app_id={app_id}&app_key={app_key}&ingr={food}",
                EdamamApiResponse.class,
                uriVariables
        );
    }
}
