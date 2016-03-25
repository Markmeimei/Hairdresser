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
    private List<PersonalRecord_Model> list;    //详细资料列表详情

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

    public List<PersonalRecord_Model> getList() {
        return list;
    }

    public void setList(List<PersonalRecord_Model> list) {
        this.list = list;
    }
}
