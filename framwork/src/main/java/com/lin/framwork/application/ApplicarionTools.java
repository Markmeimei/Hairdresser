package com.lin.framwork.application;

import android.content.Context;

import com.android.volley.RequestQueue;

/**
 * Created by 林炜智 on 2015/9/23.
 */
public class ApplicarionTools {
    //  Volley网络请求
    public static RequestQueue requestQueue;
    //  全局用户ID
    public static String userId;

    public static RequestQueue getHttpRequestQueue(Context context) {
        if (context == null)
            return null;
        MyApplication app = (MyApplication) context.getApplicationContext();
        requestQueue = app.getHttpRequestQueue();
        return requestQueue;
    }

    public static String getUserId() {
        return userId;
    }

    public static void setUserId(String userId) {
        ApplicarionTools.userId = userId;
    }

}
