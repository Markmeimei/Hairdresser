package com.eron.hairdresser.model;

/**
 * Created by 林炜智 on 2016/3/28.
 */
public class Product_Model {
    private String img; //产品图片
    private String name;    //产品名称
    private String type;    //类型
    private String price;   //价格
    private String effect;  //产品功效
    private String ingredient;  //产品成分

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }
}
