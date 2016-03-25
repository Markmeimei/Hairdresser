package com.lin.framwork.utils;

import android.os.Handler;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.lin.framwork.application.MyApplication;
import com.lin.framwork.model.CommonJson;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by 林炜智 on 2016/3/7.
 */
public class VolleyUtil<T> implements Serializable {
    static Handler handler = new Handler();

    public interface GetCallback {
        public void onSuccess(String result, List list);

        public void onFailure(String error);
    }

    public interface PostCallback {
        public void onSuccess(String result, List list);

        public void onFailure(String error);
    }

    /**
     * Get请求解析Json
     */
    public void get(String Url, final Class clss, String Tag, final GetCallback callback) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Url, new Response.Listener<String>() {
            @Override
            public void onResponse(final String response) {
                String jsonString = response;
                if (jsonString.startsWith("ï»¿"))
                    jsonString = jsonString.substring(3);
                if (jsonString.startsWith("{"))
                    jsonString = "{\"data\":[" + jsonString + "]}";
                else if (jsonString.startsWith("["))
                    jsonString = "{\"data\":" + jsonString + "}";
                else
                    jsonString = response;
                final CommonJson<T> jsonList = CommonJson.fromJson(jsonString.replace("T", " "), clss);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(response, jsonList.getData());
                    }
                });
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onFailure(error.toString());
            }
        });
        stringRequest.setTag(Tag);
        MyApplication.getHttpRequestQueue().add(stringRequest);
    }

    /**
     * Post请求解析Json
     */
    public void post(String Url, final Class clss, String Tag, final Map<String, String> map, final PostCallback callback) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Url, new Response.Listener<String>() {
            @Override
            public void onResponse(final String response) {
                String jsonString = response;
                if (jsonString.startsWith("ï»¿"))
                    jsonString = jsonString.substring(3);
                if (jsonString.startsWith("{"))
                    jsonString = "{\"data\":[" + jsonString + "]}";
                else if (jsonString.startsWith("["))
                    jsonString = "{\"data\":" + jsonString + "}";
                else
                    jsonString = response;
                final CommonJson<T> jsonList = CommonJson.fromJson(jsonString.replace("T", " "), clss);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(response, jsonList.getData());
                    }
                });
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onFailure(error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }
        };
        stringRequest.setTag(Tag);
        MyApplication.getHttpRequestQueue().add(stringRequest);
    }
}
