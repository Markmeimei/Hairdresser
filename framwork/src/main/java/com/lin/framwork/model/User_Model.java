package com.lin.framwork.model;

/**
 * Created by 林炜智 on 2016/3/29.
 */
public class User_Model {

    /**
     * code : 1
     * message :
     * object : {"id":"1","nick":"admin","pwd":"202cb962ac59075b964b07152d234b70","name":"管理员","idcn":null,"sex":"1","rid":"1","permit":"-1,92,93,94,95,87,89,90,4,91,6,86,78,12,80,16,65,66,1,10,14,13,79,64,18,17","bid":"1","job":"超级管理员","portrait":"uploads/portrait/admin.jpg","phone":null,"creator":"0","regtime":"0","logintime":"1458027703","loginip":"::1"}
     */

    private String code;
    private String message;
    /**
     * id : 1
     * nick : admin
     * pwd : 202cb962ac59075b964b07152d234b70
     * name : 管理员
     * idcn : null
     * sex : 1
     * rid : 1
     * permit : -1,92,93,94,95,87,89,90,4,91,6,86,78,12,80,16,65,66,1,10,14,13,79,64,18,17
     * bid : 1
     * job : 超级管理员
     * portrait : uploads/portrait/admin.jpg
     * phone : null
     * creator : 0
     * regtime : 0
     * logintime : 1458027703
     * loginip : ::1
     */

    private ObjectBean object;

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

    public ObjectBean getObject() {
        return object;
    }

    public void setObject(ObjectBean object) {
        this.object = object;
    }

    public static class ObjectBean {
        private String id;
        private String nick;
        private String pwd;
        private String name;
        private Object idcn;
        private String sex;
        private String rid;
        private String permit;
        private String bid;
        private String job;
        private String portrait;
        private Object phone;
        private String creator;
        private String regtime;
        private String logintime;
        private String loginip;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNick() {
            return nick;
        }

        public void setNick(String nick) {
            this.nick = nick;
        }

        public String getPwd() {
            return pwd;
        }

        public void setPwd(String pwd) {
            this.pwd = pwd;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getIdcn() {
            return idcn;
        }

        public void setIdcn(Object idcn) {
            this.idcn = idcn;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getRid() {
            return rid;
        }

        public void setRid(String rid) {
            this.rid = rid;
        }

        public String getPermit() {
            return permit;
        }

        public void setPermit(String permit) {
            this.permit = permit;
        }

        public String getBid() {
            return bid;
        }

        public void setBid(String bid) {
            this.bid = bid;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public String getPortrait() {
            return portrait;
        }

        public void setPortrait(String portrait) {
            this.portrait = portrait;
        }

        public Object getPhone() {
            return phone;
        }

        public void setPhone(Object phone) {
            this.phone = phone;
        }

        public String getCreator() {
            return creator;
        }

        public void setCreator(String creator) {
            this.creator = creator;
        }

        public String getRegtime() {
            return regtime;
        }

        public void setRegtime(String regtime) {
            this.regtime = regtime;
        }

        public String getLogintime() {
            return logintime;
        }

        public void setLogintime(String logintime) {
            this.logintime = logintime;
        }

        public String getLoginip() {
            return loginip;
        }

        public void setLoginip(String loginip) {
            this.loginip = loginip;
        }
    }
}
