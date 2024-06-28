package com.ping.sportplatform.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EdamamApiResponse {

    // 查詢失敗會得到的欄位
    private String errorCode;
    private String message;
    private String[] params;

    // 營養資訊
    @JsonProperty("ENERC_KCAL") // 能量 energy 單位:千卡
    private Double enercKcal;

    @JsonProperty("PROCNT") // 蛋白質 protein 單位:克
    private Double procnt;

    @JsonProperty("FAT") // 脂肪 fat 單位:克
    private Double fat;

    @JsonProperty("CHOCDF") // 碳水化合物 carbohydrate 單位:克
    private Double chocdf;

    @JsonProperty("FIBTG") // 膳食纖維 Fiber 單位:克
    private Double fibtg;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String[] getParams() {
        return params;
    }

    public void setParams(String[] params) {
        this.params = params;
    }

    public Double getEnercKcal() {
        return enercKcal;
    }

    public void setEnercKcal(Double enercKcal) {
        this.enercKcal = enercKcal;
    }

    public Double getProcnt() {
        return procnt;
    }

    public void setProcnt(Double procnt) {
        this.procnt = procnt;
    }

    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }

    public Double getChocdf() {
        return chocdf;
    }

    public void setChocdf(Double chocdf) {
        this.chocdf = chocdf;
    }

    public Double getFibtg() {
        return fibtg;
    }

    public void setFibtg(Double fibtg) {
        this.fibtg = fibtg;
    }
}
