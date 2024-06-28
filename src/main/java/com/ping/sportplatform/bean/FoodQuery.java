package com.ping.sportplatform.bean;

public class FoodQuery {

    private String query;// 查詢食物名稱

    public FoodQuery() {
    }

    public FoodQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return "FoodQuery{" +
                "query='" + query + '\'' +
                '}';
    }
}
