package com.lin.framwork.config;

/**
 * Created by 林炜智 on 2016/3/21.
 */
public class Config {
    private static String Url = "http://10.9.17.193:8080/msmhaircut/";  //测试地址

//    private static String Url = "http://HTTP_HOST/msmhaircut/";

    private static String BasePath = "app-api/";

    private static String Path = "mobile.mysql.php?act=";

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
