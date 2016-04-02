package com.eron.hairdresser.model;

/**
 * Created by 林炜智 on 2016/4/2.
 */
public class CompanyProfile_Model {

    /**
     * id : 3
     * title : 迁升制度
     * pid : 0
     * type : 2
     * desc : null
     * cont : <p>
     * <img src="http://10.9.17.193:8080/msmhaircut/uploads/editorImage/2016/04/02101618-61784.jpg" alt="" />
     * </p>
     * <p>
     * 迁升制度迁升制度迁升<strong><span style="background-color:#FF9900;">制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁</span></strong>升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度v
     * </p>
     * seq : 1
     * url : null
     * verify : 2
     * hide : 2
     * nav : 2
     */

    private ObjectBean object;
    /**
     * object : {"id":"3","title":"迁升制度","pid":"0","type":"2","desc":null,"cont":"<p>\r\n\t<img src=\"http://10.9.17.193:8080/msmhaircut/uploads/editorImage/2016/04/02101618-61784.jpg\" alt=\"\" /> \r\n<\/p>\r\n<p>\r\n\t迁升制度迁升制度迁升<strong><span style=\"background-color:#FF9900;\">制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁<\/span><\/strong>升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度迁升制度v\r\n<\/p>","seq":"1","url":null,"verify":"2","hide":"2","nav":"2"}
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
        private String id;  //ID
        private String title;   //标题
        private String pid;
        private String type;
        private String cont;    //内容
        private String seq;
        private String verify;
        private String hide;
        private String nav;

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

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getCont() {
            return cont;
        }

        public void setCont(String cont) {
            this.cont = cont;
        }

        public String getSeq() {
            return seq;
        }

        public void setSeq(String seq) {
            this.seq = seq;
        }

        public String getVerify() {
            return verify;
        }

        public void setVerify(String verify) {
            this.verify = verify;
        }

        public String getHide() {
            return hide;
        }

        public void setHide(String hide) {
            this.hide = hide;
        }

        public String getNav() {
            return nav;
        }

        public void setNav(String nav) {
            this.nav = nav;
        }
    }
}
