package com.eron.hairdresser.model;

/**
 * Created by 林炜智 on 2016/3/29.
 */
public class HomeHint_Model {

    /**
     * code : 1
     * message :
     * object : {"birth":2,"outdate":3,"appointment":5,"datetime":"2016/03/29"}
     */

    private String code;
    private String message;
    /**
     * birth : 2
     * outdate : 3
     * appointment : 5
     * datetime : 2016/03/29
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
        private int birth;
        private int outdate;
        private int appointment;
        private String datetime;

        public int getBirth() {
            return birth;
        }

        public void setBirth(int birth) {
            this.birth = birth;
        }

        public int getOutdate() {
            return outdate;
        }

        public void setOutdate(int outdate) {
            this.outdate = outdate;
        }

        public int getAppointment() {
            return appointment;
        }

        public void setAppointment(int appointment) {
            this.appointment = appointment;
        }

        public String getDatetime() {
            return datetime;
        }

        public void setDatetime(String datetime) {
            this.datetime = datetime;
        }
    }
}
