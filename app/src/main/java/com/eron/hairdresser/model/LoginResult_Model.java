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

    private String code;
    private String message;
    private String object;

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

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }
}
