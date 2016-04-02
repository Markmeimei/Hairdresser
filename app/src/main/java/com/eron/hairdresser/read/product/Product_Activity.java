package com.eron.hairdresser.read.product;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.android.volley.VolleyError;
import com.eron.hairdresser.R;
import com.eron.hairdresser.adapter.Product_Activity_ListView_Adapter;
import com.eron.hairdresser.common.TagName;
import com.eron.hairdresser.model.Product_Model;
import com.eron.hairdresser.views.headTitle.HeadTitle;
import com.google.gson.Gson;
import com.lin.framwork.config.ConfigUrl;
import com.lin.framwork.utils.IntentUtil;
import com.lin.framwork.utils.VolleyUtil;
import com.lin.framwork.views.Toast_Control.Toast_Common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

public class Product_Activity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    public final static String Tag = "Product_Activity";

    @Bind(R.id.activity_product_HeadTitle)
    HeadTitle activityProductHeadTitle;
    @Bind(R.id.activity_product_ListView)
    ListView activityProductListView;
    @Bind(R.id.activity_product_SwipeRefreshLayout)
    SwipeRefreshLayout activityProductSwipeRefreshLayout;

    private Product_Activity_ListView_Adapter listView_adapter;
    private List<Product_Model.ObjectBean> modelList;
    private Handler handler;
    private Map<String, String> map;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        ButterKnife.bind(this);
        Init();
    }

    private void Init() {
        intent = getIntent();
        modelList = new ArrayList<>();
        map = new HashMap<>();
        handler = new Handler();
        listView_adapter = new Product_Activity_ListView_Adapter(this, modelList);
        Content();
    }

    private void Content() {
        if (intent.getStringExtra(TagName.ReadTag).equals("2")) {
            map.put("cat", "1");
        }
        if (intent.getStringExtra(TagName.ReadTag).equals("3")) {
            map.put("cat", "2");
        }
        if (intent.getStringExtra(TagName.ReadTag).equals("4")) {
            map.put("cat", "3");
        }
        activityProductListView.setAdapter(listView_adapter);
        activityProductSwipeRefreshLayout.setColorSchemeResources(R.color.adapter_birthday_activity_listview_checkbox01,
                R.color.adapter_birthday_activity_listview_checkbox02, R.color.adapter_birthday_activity_listview_checkbox03);
        activityProductSwipeRefreshLayout.setOnRefreshListener(this);
        getData();
    }

    private void getData() {
        new VolleyUtil<>().post(ConfigUrl.Product_ActivityUrl, Product_Model.class, Tag, map, new VolleyUtil.PostCallback() {
            @Override
            public void onSuccess(String result, List list) {
                Product_Model model = new Gson().fromJson(result, Product_Model.class);
                modelList.addAll(model.getObject());
                listView_adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(VolleyError error) {
                Toast_Common.DefaultToast(Product_Activity.this, "网络请求失败，请检查网络");
            }
        });
    }

    @OnItemClick(R.id.activity_product_ListView)
    public void onItemClick(int position) {
        IntentUtil.goToContext(this, ProductDetails_Activity.class);
    }

    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                modelList.clear();
                getData();
                activityProductSwipeRefreshLayout.setRefreshing(false);
            }
        }, 1000);
    }
}
