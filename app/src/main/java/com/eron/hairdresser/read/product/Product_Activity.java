package com.eron.hairdresser.read.product;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.eron.hairdresser.R;
import com.eron.hairdresser.adapter.Product_Activity_ListView_Adapter;
import com.eron.hairdresser.model.Product_Model;
import com.eron.hairdresser.views.headTitle.HeadTitle;
import com.lin.framwork.utils.IntentUtil;
import com.lin.framwork.views.Toast_Control.Toast_Common;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

public class Product_Activity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.activity_product_HeadTitle)
    HeadTitle activityProductHeadTitle;
    @Bind(R.id.activity_product_ListView)
    ListView activityProductListView;
    @Bind(R.id.activity_product_SwipeRefreshLayout)
    SwipeRefreshLayout activityProductSwipeRefreshLayout;

    private Product_Activity_ListView_Adapter listView_adapter;
    private List<Product_Model> modelList;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Toast_Common.DefaultToast(Product_Activity.this, "刷新");
            activityProductSwipeRefreshLayout.setRefreshing(false);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        ButterKnife.bind(this);
        Init();
    }

    private void Init() {
        modelList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Product_Model model = new Product_Model();
            model.setName("这里是产品的名称");
            model.setType("热烫");
            model.setPrice("10086元");
            modelList.add(model);
        }

        listView_adapter = new Product_Activity_ListView_Adapter(this, modelList);
        Content();
    }

    private void Content() {
        activityProductListView.setAdapter(listView_adapter);
        activityProductSwipeRefreshLayout.setColorSchemeResources(R.color.adapter_birthday_activity_listview_checkbox01,
                R.color.adapter_birthday_activity_listview_checkbox02, R.color.adapter_birthday_activity_listview_checkbox03);
        activityProductSwipeRefreshLayout.setOnRefreshListener(this);
    }

    @OnItemClick(R.id.activity_product_ListView)
    public void onItemClick(int position) {
        IntentUtil.goToContext(this, ProductDetails_Activity.class);
    }

    @Override
    public void onRefresh() {
        handler.sendEmptyMessageDelayed(RESULT_CANCELED, 3000);
    }
}
