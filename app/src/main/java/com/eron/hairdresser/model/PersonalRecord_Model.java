package com.eron.hairdresser.model;

/**
 * Created by 林炜智 on 2016/3/15.
 * 详细资料列表详情
 */
public class PersonalRecord_Model {
    private String date;    //时间
    private String project; //项目
    private String hairstylistName; //发型师姓名
    private String product; //使用产品
    private String type;    //类型
    private String useBeforeImg;    //使用前图片
    private String afterUseImg; //使用后图片
    private String satisfaction;    //满意度
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

    public String getHairstylistName() {
        return hairstylistName;
    }

    public void setHairstylistName(String hairstylistName) {
        this.hairstylistName = hairstylistName;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUseBeforeImg() {
        return useBeforeImg;
    }

    public void setUseBeforeImg(String useBeforeImg) {
        this.useBeforeImg = useBeforeImg;
    }

    public String getAfterUseImg() {
        return afterUseImg;
    }

    public void setAfterUseImg(String afterUseImg) {
        this.afterUseImg = afterUseImg;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public String getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(String satisfaction) {
        this.satisfaction = satisfaction;
    }
}
