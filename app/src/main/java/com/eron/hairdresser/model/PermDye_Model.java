package com.eron.hairdresser.model;

import java.util.List;

/**
 * Created by 林炜智 on 2016/3/15.
 * 详细资料列表详情
 */
public class PermDye_Model {

    /**
     * object : [{"id":"1","serial":"222","vipcode":"222","viptype":"1","name":"22","phone":"222","sex":"1","birth":"2016-03-09","grade":null,"money":"22.00","health":"2","length":"3","lasttime":null,"addtime":"2016-03-29 09:50:54","adduid":null},{"id":"2","serial":"123456","vipcode":"123456","viptype":"1","name":"隔壁老王","phone":"17000000000","sex":"1","birth":"2016-04-01","grade":null,"money":"300.00","health":"1","length":"1","lasttime":null,"addtime":"2016-04-01 16:48:23","adduid":null},{"id":"3","serial":"123456","vipcode":null,"viptype":"1","name":null,"phone":null,"sex":"1","birth":"2016-04-01","grade":null,"money":null,"health":"1","length":"1","lasttime":null,"addtime":"2016-04-01 16:50:50","adduid":null},{"id":"4","serial":"123456","vipcode":"123456","viptype":"1","name":"隔壁老王","phone":"17000000000","sex":"1","birth":"2016-04-01","grade":null,"money":"300.00","health":"1","length":"1","lasttime":null,"addtime":"2016-04-01 16:51:03","adduid":null}]
     * code : 1
     * message :
     */

    private String code;
    private String message;
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

    public static class ObjectBean {
        private String id;  //ID
        private String serial;
        private String vipcode; //卡号
        private String viptype; //卡类
        private String name;    //姓名
        private String phone;   //手机
        private String sex; //性别
        private String birth;   //生日
        private Object grade;
        private String money;   //金额
        private String health;  //头发健康指数
        private String length;  //头发长度
        private Object lasttime;
        private String addtime; //添加时间
        private Object adduid;
        private boolean show;   //显示（个人使用）

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

        public Object getGrade() {
            return grade;
        }

        public void setGrade(Object grade) {
            this.grade = grade;
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

        public Object getLasttime() {
            return lasttime;
        }

        public void setLasttime(Object lasttime) {
            this.lasttime = lasttime;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public Object getAdduid() {
            return adduid;
        }

        public void setAdduid(Object adduid) {
            this.adduid = adduid;
        }

        public boolean isShow() {
            return show;
        }

        public void setShow(boolean show) {
            this.show = show;
        }
    }
}
