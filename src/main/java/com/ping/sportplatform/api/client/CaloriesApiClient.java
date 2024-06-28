package com.ping.sportplatform.api.client;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
public class CaloriesApiClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public String getCalories(String activity, Integer weight, Integer duration) {

        String url = "https://api.api-ninjas.com/v1/caloriesburned?activity={activity}&weight={weight}&duration={duration}";

        // headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("X-Api-Key", "gxcBCmtEmz+I0NlPw4OOzw==HCVNLlC0Pz4uxc69");
        // httpEntity
        HttpEntity httpEntity = new HttpEntity(headers);

        try{

            ResponseEntity<String> resEntity = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    httpEntity,
                    String.class,
                    Map.of(
                            "activity", activity,
                            "weight", weight,
                            "duration", duration
                    )
            );
            System.out.println("client: " + resEntity.getBody());

            if(resEntity.getStatusCode().equals(HttpStatus.OK)){
                return resEntity.getBody();
            }else {
                System.out.println("返回結果不等於200: status Code = " + resEntity.getStatusCode().value());
            }
        }catch (RestClientException e){
            e.printStackTrace();
        }
        return null;
    }
}
