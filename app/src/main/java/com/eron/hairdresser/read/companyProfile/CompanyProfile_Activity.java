package com.eron.hairdresser.read.companyProfile;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.eron.hairdresser.R;
import com.eron.hairdresser.common.TagName;
import com.eron.hairdresser.model.CompanyProfile_Model;
import com.eron.hairdresser.views.headTitle.HeadTitle;
import com.google.gson.Gson;
import com.lin.framwork.config.ConfigUrl;
import com.lin.framwork.utils.VolleyUtil;
import com.lin.framwork.views.Toast_Control.Toast_Common;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CompanyProfile_Activity extends AppCompatActivity {
    public final static String Tag = "CompanyProfile_Activity";

    @Bind(R.id.activity_company_profile_HeadTitle)
    HeadTitle activityCompanyProfileHeadTitle;
    @Bind(R.id.activity_company_profile_WebView)
    WebView activityCompanyProfileWebView;

    private Intent intent;
    private Map<String, String> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_profile);
        ButterKnife.bind(this);
        Init();
    }

    private void Init() {
        intent = getIntent();
        map = new HashMap<>();
        Content();
    }

    private void Content() {
        if (intent.getStringExtra(TagName.ReadTag).equals("2")) {
            map.put("id", "2");
        }
        if (intent.getStringExtra(TagName.ReadTag).equals("3")) {
            map.put("id", "3");
        }
        if (intent.getStringExtra(TagName.ReadTag).equals("4")) {
            map.put("id", "4");
        }

        getData();
    }

    private void getData() {
        new VolleyUtil<>().post(ConfigUrl.CompanyProfile_ActivityUrl, CompanyProfile_Model.class, Tag, map, new VolleyUtil.PostCallback() {
            @Override
            public void onSuccess(String result, List list) {
                CompanyProfile_Model model = new Gson().fromJson(result, CompanyProfile_Model.class);
                activityCompanyProfileWebView.loadDataWithBaseURL(null, model.getObject().getCont(), "text/html", "UTF-8", null);
            }

            @Override
            public void onFailure(VolleyError error) {
                Toast_Common.DefaultToast(CompanyProfile_Activity.this, "网络请求失败，请检查网络");
            }
        });
    }
}
