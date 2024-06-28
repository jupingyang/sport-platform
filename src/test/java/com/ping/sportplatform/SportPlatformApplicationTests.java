package com.ping.sportplatform;

import com.ping.sportplatform.api.client.CaloriesApiClient;
import com.ping.sportplatform.api.client.EdamamApiClient1;
import com.ping.sportplatform.api.client.EdamamApiClient2;
import com.ping.sportplatform.api.component.EdamamApiComponent;
import com.ping.sportplatform.api.response.EdamamApiResponse;
import com.ping.sportplatform.api.response.IpApiResponse;
import com.ping.sportplatform.api.client.IpApiClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SportPlatformApplicationTests {

    @Autowired
    private IpApiClient ipApiClient;
    @Autowired
    private EdamamApiComponent edamamApiComponent;
    @Autowired
    private EdamamApiClient1 edamamApiClient1;
    @Autowired
    private EdamamApiClient2 edamamApiClient2;
    @Autowired
    private CaloriesApiClient caloriesApiClient;

    @Test
    public void contextLoads() {
        System.out.println("測試開始");
    }

    @Test
    public void testIpApiClient_Public() {
        IpApiResponse ipInfo = ipApiClient.getIpInfo("208.67.222.222");

        // 確認查詢時是否有問題
        assertFalse(ipInfo.isError());
        assertNull(ipInfo.getReason());
        assertFalse(ipInfo.isReserved());

        // 確認 IP 所在地資訊
        assertEquals("San Francisco", ipInfo.getCity());
        assertEquals("USD", ipInfo.getCurrency());
        assertEquals( -122.397966, ipInfo.getLongitude(), 0);
        assertEquals(37.774778, ipInfo.getLatitude(), 0);
        assertEquals("-0700", ipInfo.getUtcOffset());
        assertEquals("+1", ipInfo.getCountryCallingCode());
    }

    @Test
    public void testIpApiClient_Private() {
        IpApiResponse ipInfo = ipApiClient.getIpInfo("192.168.8.100");

        assertTrue(ipInfo.isError());
        assertEquals("Reserved IP Address", ipInfo.getReason());
        assertTrue(ipInfo.isReserved());
    }


    @Test
    public void testEdamamApiService(){
        System.out.println(edamamApiComponent);
    }

    /**
     * java.lang.NullPointerException:
     * Cannot invoke "java.lang.Double.doubleValue()"
     * because the return value of "com.ping.sportplatform.api.response.EdamamApiResponse.getEnercKcal()" is null
     *
     */
    @Test
    public void testEdamamApiClient1(){
        EdamamApiResponse foodData = edamamApiClient1.getFoodData("apple");

        // 確認查詢時是否有問題
        assertNull(foodData.getErrorCode());
        assertNull(foodData.getMessage());
        assertNull(foodData.getParams());

        // 確認 apple 的 foodData
        assertEquals(52, foodData.getEnercKcal(),0);
        assertEquals(0.26, foodData.getProcnt(),0);
        assertEquals( 0.17, foodData.getFat(),0);
        assertEquals(13.8, foodData.getChocdf(),0);
        assertEquals( 2.4, foodData.getFibtg(),0);
    }

    @Test
    public void testEdamamApiClient2(){
        String data = edamamApiClient2.getFoodData("apple");

        assertNotNull(data);
        System.out.println(data);
    }

    @Test
    public void testCaloriesApiClient(){
        String data = caloriesApiClient.getCalories("skiing", 160, 60);
        assertNotNull(data);
        System.out.println(data);
    }
}