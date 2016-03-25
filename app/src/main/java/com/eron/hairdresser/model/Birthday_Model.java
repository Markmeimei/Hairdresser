package com.eron.hairdresser.model;

/**
 * Created by 林炜智 on 2016/3/14.
 * 生日提示类
 */
public class Birthday_Model {
    private String img; //头像
    private String time;    //日期
    private String name;    //姓名
    private String age; //年龄
    private Boolean show;   //（个人使用）折叠显示

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

}
