package com.eron.hairdresser.model;

import java.util.List;

/**
 * Created by 林炜智 on 2016/3/28.
 */
public class Product_Model {

    /**
     * code : 1
     * message :
     * object : [{"id":"3","cat":"1","title":"222","type":null,"picture":"utility/2016/02/25151236-35400.png","feature":"222","contain":"222","adduid":null,"addtime":"2016-02-25 15:12:11"}]
     */

    private String code;
    private String message;
    /**
     * id : 3
     * cat : 1
     * title : 222
     * type : null
     * picture : utility/2016/02/25151236-35400.png
     * feature : 222
     * contain : 222
     * adduid : null
     * addtime : 2016-02-25 15:12:11
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
        private String id;
        private String cat;
        private String title;
        private String type;
        private String picture;
        private String feature;
        private String contain;
        private String addtime;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCat() {
            return cat;
        }

        public void setCat(String cat) {
            this.cat = cat;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public String getFeature() {
            return feature;
        }

        public void setFeature(String feature) {
            this.feature = feature;
        }

        public String getContain() {
            return contain;
        }

        public void setContain(String contain) {
            this.contain = contain;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }
    }
}
