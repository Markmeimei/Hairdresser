package com.eron.hairdresser.model;

import java.util.List;

/**
 * Created by 林炜智 on 2016/3/12.
 * 顾客类
 */
public class Customer_Model {
    private String name;    //姓名
    private String cardNumber;  //卡号
    private int cardVariety;    //卡类
    private String gender;  //性别
    private String birthday;    //生日
    private String quality; //品质
    private String hairLength;  //发长
    private String phone;   //电话
    private List<PermDye_Model> permDye_models;    //详细资料列表详情
    private List<Nutrition_Model> nutrition_models; //  美容记录详细列表
    private List<SPA_Model> spa_models;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCardVariety() {
        return cardVariety;
    }

    public void setCardVariety(int cardVariety) {
        this.cardVariety = cardVariety;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getHairLength() {
        return hairLength;
    }

    public void setHairLength(String hairLength) {
        this.hairLength = hairLength;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<PermDye_Model> getPermDye_models() {
        return permDye_models;
    }

    public void setPermDye_models(List<PermDye_Model> permDye_models) {
        this.permDye_models = permDye_models;
    }

    public List<Nutrition_Model> getNutrition_models() {
        return nutrition_models;
    }

    public void setNutrition_models(List<Nutrition_Model> nutrition_models) {
        this.nutrition_models = nutrition_models;
    }

    public List<SPA_Model> getSpa_models() {
        return spa_models;
    }

    public void setSpa_models(List<SPA_Model> spa_models) {
        this.spa_models = spa_models;
    }
}
