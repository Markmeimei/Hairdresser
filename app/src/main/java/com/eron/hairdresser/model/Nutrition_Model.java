package com.eron.hairdresser.model;

/**
 * Created by 林炜智 on 2016/3/25.
 */
public class Nutrition_Model {
    private String date;    //时间
    private String project; //项目
    private String product; //使用产品
    private String product2; //使用产品
    private String diagnosis;    //头皮诊断
    private String storesUse;    //店用
    private String furnishing;    //家居
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

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getProduct2() {
        return product2;
    }

    public void setProduct2(String product2) {
        this.product2 = product2;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getStoresUse() {
        return storesUse;
    }

    public void setStoresUse(String storesUse) {
        this.storesUse = storesUse;
    }

    public String getFurnishing() {
        return furnishing;
    }

    public void setFurnishing(String furnishing) {
        this.furnishing = furnishing;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }
}
