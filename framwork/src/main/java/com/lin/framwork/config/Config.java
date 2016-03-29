package com.lin.framwork.config;

/**
 * Created by 林炜智 on 2016/3/21.
 */
public class Config {
    private final static String Url = "http://10.9.17.193:8080/msmhaircut/";  //测试地址

    private final static String BasePath = "app-api/";

    private final static String Path = "mobile.mysql.php?act=";

    /**
     * 基础Url
     */
    public static String getBasePathUrl() {
        return Url + BasePath;
    }

    public static String getUrlPath() {
        return Url + BasePath + Path;
    }
}
