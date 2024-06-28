package com.ping.sportplatform.controller;

import com.alibaba.fastjson.JSON;
import com.ping.sportplatform.api.client.EdamamApiClient2;
import com.ping.sportplatform.bean.FoodQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class FoodController {

    @Autowired
    private EdamamApiClient2 edamamApiClient2;

    @RequestMapping("/getFood")
    public String getFoodData(FoodQuery foodQuery){

        String query = foodQuery.getQuery();
        System.out.println(query);
        String res = edamamApiClient2.getFoodData(query);

        System.out.println(res);
        return res;
    }
}
