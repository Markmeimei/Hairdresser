package com.eron.hairdresser.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 林炜智 on 2016/3/16.
 * 阅读发型图片类
 */
public class HairStyleImg_Model {

    /**
     * object : [{"0":"366","1":"测试","2":"/msmhaircut/uploads/editorImage/2016/04/02085217-18344.jpg","3":"2016-04-02 08:52:01","id":"366","title":"测试","thumb":"http://10.9.17.193:8080/msmhaircut/uploads/editorImage/2016/04/02085217-18344.jpg","addtime":"2016-04-02 08:52:01"},{"0":"368","1":"测试2","2":"/msmhaircut/uploads/editorImage/2016/04/02085256-77206.jpg","3":"2016-04-02 08:52:41","id":"368","title":"测试2","thumb":"http://10.9.17.193:8080/msmhaircut/uploads/editorImage/2016/04/02085256-77206.jpg","addtime":"2016-04-02 08:52:41"}]
     * code : 1
     * message :
     */

    private String code;
    private String message;
    /**
     * 0 : 366
     * 1 : 测试
     * 2 : /msmhaircut/uploads/editorImage/2016/04/02085217-18344.jpg
     * 3 : 2016-04-02 08:52:01
     * id : 366
     * title : 测试
     * thumb : http://10.9.17.193:8080/msmhaircut/uploads/editorImage/2016/04/02085217-18344.jpg
     * addtime : 2016-04-02 08:52:01
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
        @SerializedName("0")
        private String value0;
        @SerializedName("1")
        private String value1;
        @SerializedName("2")
        private String value2;
        @SerializedName("3")
        private String value3;
        private String id;
        private String title;
        private String thumb;
        private String addtime;

        public String getValue0() {
            return value0;
        }

        public void setValue0(String value0) {
            this.value0 = value0;
        }

        public String getValue1() {
            return value1;
        }

        public void setValue1(String value1) {
            this.value1 = value1;
        }

        public String getValue2() {
            return value2;
        }

        public void setValue2(String value2) {
            this.value2 = value2;
        }

        public String getValue3() {
            return value3;
        }

        public void setValue3(String value3) {
            this.value3 = value3;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }
    }
}
