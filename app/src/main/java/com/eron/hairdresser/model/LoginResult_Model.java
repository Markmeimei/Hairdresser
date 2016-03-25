package com.eron.hairdresser.model;

/**
 * Created by 林炜智 on 2016/3/23.
 */
public class LoginResult_Model {

    /**
     * error : 0
     * msg : 登陆成功！
     * uid : 1
     */

    private String error;
    private String msg;
    private String uid;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
