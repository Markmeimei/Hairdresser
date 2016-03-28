package com.eron.hairdresser.model;

/**
 * Created by 林炜智 on 2016/3/28.
 */
public class SPA_Model {
    private String date;    //时间
    private String project; //项目
    private String mask;    //使用的面膜
    private String assistant;   //助理
    private String appointmentTime; //下次预约时间
    private String appointmentPerson;   //预约人
    private String signature;   //签名图片
    private Boolean show;   //（个人使用）折叠显示

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public String getAssistant() {
        return assistant;
    }

    public void setAssistant(String assistant) {
        this.assistant = assistant;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getAppointmentPerson() {
        return appointmentPerson;
    }

    public void setAppointmentPerson(String appointmentPerson) {
        this.appointmentPerson = appointmentPerson;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }
}
