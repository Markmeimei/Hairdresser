package com.eron.hairdresser.model;

/**
 * Created by 林炜智 on 2016/3/28.
 */
public class ProductDetails_Model {

    /**
     * id : 1
     * cat : 2
     * title : 111
     * type : 染发
     * price : null
     * picture : http://10.9.17.193:8080/msmhaircut/utility/2016/02/25144135-13787.jpg
     * feature : 111
     * contain : 111
     * adduid : null
     * addtime : 2016-02-25 13:34:40
     */

    private ObjectBean object;
    /**
     * object : {"id":"1","cat":"2","title":"111","type":"染发","price":null,"picture":"http://10.9.17.193:8080/msmhaircut/utility/2016/02/25144135-13787.jpg","feature":"111","contain":"111","adduid":null,"addtime":"2016-02-25 13:34:40"}
     * code : 1
     * message :
     */

    private String code;
    private String message;

    public ObjectBean getObject() {
        return object;
    }

    public void setObject(ObjectBean object) {
        this.object = object;
    }

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

    public static class ObjectBean {
        private String id;
        private String cat;
        private String title;
        private String type;
        private Object price;
        private String picture;
        private String feature;
        private String contain;
        private Object adduid;
        private String addtime;

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

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Object getPrice() {
            return price;
        }

        public void setPrice(Object price) {
            this.price = price;
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

        public Object getAdduid() {
            return adduid;
        }

        public void setAdduid(Object adduid) {
            this.adduid = adduid;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }
    }
}
