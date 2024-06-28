package com.ping.sportplatform.controller;

import com.alibaba.fastjson.JSON;
import com.ping.sportplatform.api.client.CaloriesApiClient;
import com.ping.sportplatform.bean.CaloriesQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class CaloriesController {

    @Autowired
    private CaloriesApiClient caloriesApiClient;

    @RequestMapping("/getCalories")
    public String getCalories(CaloriesQuery caloriesQuery){

        // activity: null, weight: 0, duration: 0
        String activity = caloriesQuery.getActivity();
        Integer weight = caloriesQuery.getWeight();
        if(weight == null){
            weight = 160;
        }
        Integer duration = caloriesQuery.getDuration();
        if(duration == null){
            weight = 60;
        }
        System.out.println("activity: " + activity + ", weight: " + weight + ", duration: " + duration);
        String res = caloriesApiClient.getCalories(activity, weight, duration);
        System.out.println("controller: " + res);

        HashMap<String,Object> data = new HashMap<>();
        if (res != null){
            data.put("data",res);
            data.put("flag","success");
        }else {
            data.put("flag","error");
        }
        String res_json = JSON.toJSONString(data);
        return res_json;
    }
}
