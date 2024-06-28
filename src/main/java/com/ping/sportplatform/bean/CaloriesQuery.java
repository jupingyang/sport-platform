package com.ping.sportplatform.bean;

public class CaloriesQuery {

    private String activity;
    private int weight;
    private int duration;

    public CaloriesQuery() {
    }

    public CaloriesQuery(String activity, int weight, int duration) {
        this.activity = activity;
        this.weight = weight;
        this.duration = duration;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "CaloriesQuery{" +
                "activity='" + activity + '\'' +
                ", weight=" + weight +
                ", duration=" + duration +
                '}';
    }
}
