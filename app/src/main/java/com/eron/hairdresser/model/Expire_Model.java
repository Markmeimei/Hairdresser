package com.eron.hairdresser.model;

import java.util.List;

/**
 * Created by 林炜智 on 2016/3/8.
 * 到期顾客
 */
public class Expire_Model {

    /**
     * code : 1
     * message :
     * object : [{"id":"1","serial":"222","vipcode":"222","viptype":"1","name":"22","phone":"222","sex":"1","birth":"2016-03-09","grade":null,"money":"22.00","health":"2","length":"3","lasttime":null,"addtime":"2016-03-29 09:50:54","adduid":null}]
     */

    private String code;
    private String message;
    private boolean show;   //显示（个人使用）
    /**
     * id : 1
     * serial : 222
     * vipcode : 222
     * viptype : 1
     * name : 22
     * phone : 222
     * sex : 1
     * birth : 2016-03-09
     * grade : null
     * money : 22.00
     * health : 2
     * length : 3
     * lasttime : null
     * addtime : 2016-03-29 09:50:54
     * adduid : null
     */

    private List<ObjectBean> object;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ObjectBean> getObject() {
        return object;
    }

    public void setObject(List<ObjectBean> object) {
        this.object = object;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public static class ObjectBean {
        private String id;      //ID
        private String serial;
        private String vipcode; //VIP编号
        private String viptype; //VIP类型
        private String name;    //姓名
        private String phone;   //手机号
        private String sex;     //性别
        private String birth;   //生日
        private String money;   //金额
        private String health;  //头发健康指数
        private String length;  //头发长度
        private String addtime; //添加时间

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSerial() {
            return serial;
        }

        public void setSerial(String serial) {
            this.serial = serial;
        }

        public String getVipcode() {
            return vipcode;
        }

        public void setVipcode(String vipcode) {
            this.vipcode = vipcode;
        }

        public String getViptype() {
            return viptype;
        }

        public void setViptype(String viptype) {
            this.viptype = viptype;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getBirth() {
            return birth;
        }

        public void setBirth(String birth) {
            this.birth = birth;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getHealth() {
            return health;
        }

        public void setHealth(String health) {
            this.health = health;
        }

        public String getLength() {
            return length;
        }

        public void setLength(String length) {
            this.length = length;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }
    }
}
