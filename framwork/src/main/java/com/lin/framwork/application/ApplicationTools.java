package com.lin.framwork.application;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.lin.framwork.model.User_Model;

/**
 * Created by 林炜智 on 2015/9/23.
 */
public class ApplicationTools {
    //  Volley网络请求
    public static RequestQueue requestQueue;
    //  全局用户信息
    public static User_Model user;

    public static RequestQueue getHttpRequestQueue(Context context) {
        if (context == null)
            return null;
        MyApplication app = (MyApplication) context.getApplicationContext();
        requestQueue = app.getHttpRequestQueue();
        return requestQueue;
    }

    public static User_Model getUser() {
        return user;
    }

    public static void setUser(User_Model user) {
        ApplicationTools.user = user;
    }

}
