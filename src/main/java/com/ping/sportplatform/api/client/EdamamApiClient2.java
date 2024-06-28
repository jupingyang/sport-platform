package com.ping.sportplatform.api.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class EdamamApiClient2 {

    private static final String APP_ID = "83cc9062";
    private static final String APP_KEY = "a50da188ee4e63701f84f12e31f87173";
    private final RestTemplate restTemplate = new RestTemplate();

    public String getFoodData(String food) {

        String json = restTemplate.getForObject(
                "https://api.edamam.com/api/food-database/v2/parser?app_id={app_id}&app_key={app_key}&ingr={food}",
                String.class,
                Map.of(
                        "app_id", APP_ID,
                        "app_key", APP_KEY,
                        "food", food
                )
        );
        System.out.println(json);

        // 重新組合需要的字串
        HashMap<String,Object> data = new HashMap<>();
        String flag = "error";

        try{

            JSONObject object = JSONObject.parseObject(json);
            JSONObject nutrients = object.getJSONArray("parsed").getJSONObject(0).getJSONObject("food").getJSONObject("nutrients");
            // 取得各項數值
            Object text = object.get("text");
            Object energy = nutrients.get("ENERC_KCAL");
            Object protein = nutrients.get("PROCNT");
            Object fat = nutrients.get("FAT");
            Object carbohydrate = nutrients.get("CHOCDF");
            Object fiber = nutrients.get("FIBTG");
            // 將數值放入 map 中再轉成 json 返回
            data.put("food",text);
            data.put("energy",energy);
            data.put("protein",protein);
            data.put("fat",fat);
            data.put("carbohydrate",carbohydrate);
            data.put("fiber",fiber);
            flag = "success";
        }catch (IndexOutOfBoundsException e){
            System.out.println("IndexOutOfBoundsException 例外發生");
        }
        data.put("flag",flag);
        String res = JSON.toJSONString(data);
        return res;
    }
}
