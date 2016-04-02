package com.eron.hairdresser.home.birthday;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.android.volley.VolleyError;
import com.eron.hairdresser.R;
import com.eron.hairdresser.adapter.Birthday_Activity_ListView_Adapter;
import com.eron.hairdresser.model.Birthday_Model;
import com.eron.hairdresser.views.headTitle.HeadTitle;
import com.google.gson.Gson;
import com.lin.framwork.application.ApplicationTools;
import com.lin.framwork.config.ConfigUrl;
import com.lin.framwork.utils.VolleyUtil;
import com.lin.framwork.views.Toast_Control.Toast_Common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Birthday_Activity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    public final static String Tag = "Birthday_Activity";

    @Bind(R.id.activity_birthday_HeadTitle)
    HeadTitle activityBirthdayHeadTitle;
    @Bind(R.id.activity_birthday_ListView)
    ListView activityBirthdayListView;
    @Bind(R.id.activity_birthday_SwipeRefreshLayout)
    SwipeRefreshLayout activityBirthdaySwipeRefreshLayout;

    private Birthday_Activity_ListView_Adapter listView_adapter;
    private List<Birthday_Model.ObjectBean> birthday_model;
    private Handler handler;
    private Map<String, String> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday);
        ButterKnife.bind(this);
        Init();
    }

    private void Init() {
        map = new HashMap<>();
        handler = new Handler();
        birthday_model = new ArrayList<>();
        listView_adapter = new Birthday_Activity_ListView_Adapter(this, birthday_model);
        Content();
    }

    private void Content() {
        activityBirthdayListView.setAdapter(listView_adapter);
        activityBirthdaySwipeRefreshLayout.setColorSchemeResources(R.color.adapter_birthday_activity_listview_checkbox01,
                R.color.adapter_birthday_activity_listview_checkbox02, R.color.adapter_birthday_activity_listview_checkbox03);
        activityBirthdaySwipeRefreshLayout.setOnRefreshListener(this);
        getData();
    }

    private void getData() {
        map.put("uid", ApplicationTools.getUser().getObject().getId());
        new VolleyUtil<>().post(ConfigUrl.Birthday_ActivityUrl, Birthday_Model.class, Tag, map, new VolleyUtil.PostCallback() {
            @Override
            public void onSuccess(String result, List list) {
                Birthday_Model model = new Gson().fromJson(result, Birthday_Model.class);
                birthday_model.addAll(model.getObject());
                listView_adapter.notifyDataSetChanged();
                activityBirthdaySwipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(VolleyError error) {
                Toast_Common.DefaultToast(Birthday_Activity.this, "网络请求失败，请检查网络");
                activityBirthdaySwipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                birthday_model.clear();
                getData();
            }
        }, 1000);
    }
}
