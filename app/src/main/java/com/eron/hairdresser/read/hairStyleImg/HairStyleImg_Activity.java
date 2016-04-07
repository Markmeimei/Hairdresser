package com.eron.hairdresser.read.hairStyleImg;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.android.volley.VolleyError;
import com.eron.hairdresser.R;
import com.eron.hairdresser.adapter.HairStyleImg_Activity_RecyclerView_Adapter;
import com.eron.hairdresser.model.HairStyleImg_Model;
import com.eron.hairdresser.views.headTitle.HeadTitle;
import com.google.gson.Gson;
import com.lin.framwork.config.ConfigUrl;
import com.lin.framwork.utils.VolleyUtil;
import com.lin.framwork.views.PopupWindow_Control.PopupWindowImageView;
import com.lin.framwork.views.Toast_Control.Toast_Common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HairStyleImg_Activity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    public final static String Tag = "HairStyleImg_Activity";

    @Bind(R.id.activity_hair_style_img_HeadTitle)
    HeadTitle activityHairStyleImgHeadTitle;
    @Bind(R.id.activity_hair_style_img_RecyclerView)
    RecyclerView activityHairStyleImgRecyclerView;
    @Bind(R.id.activity_hair_style_img_SwipeRefreshLayout)
    SwipeRefreshLayout activityHairStyleImgSwipeRefreshLayout;

    private HairStyleImg_Activity_RecyclerView_Adapter recyclerView_adapter;
    private Handler handler;
    private Map<String, String> map;
    private List<HairStyleImg_Model.ObjectBean> modelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hair_style_img);
        ButterKnife.bind(this);
        Init();
    }

    private void Init() {
        handler = new Handler();
        map = new HashMap<>();
        recyclerView_adapter = new HairStyleImg_Activity_RecyclerView_Adapter(this, modelList);
        recyclerView_adapter.setOnItemClickLitener(new HairStyleImg_Activity_RecyclerView_Adapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                PopupWindowImageView imageView = new PopupWindowImageView(HairStyleImg_Activity.this,modelList.get(position).getThumb(),R.mipmap.img_default_loading,R.mipmap.img_default_error);
                imageView.showPopupWindow(activityHairStyleImgHeadTitle);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast_Common.CenterToast(HairStyleImg_Activity.this,"长按");
            }
        });
        Content();
    }

    private void Content() {
        activityHairStyleImgRecyclerView.setItemAnimator(new DefaultItemAnimator());
        activityHairStyleImgRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        activityHairStyleImgRecyclerView.setAdapter(recyclerView_adapter);

        activityHairStyleImgSwipeRefreshLayout.setColorSchemeResources(R.color.adapter_birthday_activity_listview_checkbox01,
                R.color.adapter_birthday_activity_listview_checkbox02, R.color.adapter_birthday_activity_listview_checkbox03);
        activityHairStyleImgSwipeRefreshLayout.setOnRefreshListener(this);
        getData();
    }

    private void getData() {
        new VolleyUtil<>().post(ConfigUrl.HairStyleImg_ActivityUrl, HairStyleImg_Model.class, Tag, map, new VolleyUtil.PostCallback() {
            @Override
            public void onSuccess(String result, List list) {
                HairStyleImg_Model model = new Gson().fromJson(result, HairStyleImg_Model.class);
                modelList.addAll(model.getObject());
                recyclerView_adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(VolleyError error) {
                Toast_Common.DefaultToast(HairStyleImg_Activity.this, "网络请求失败，请检查网络");
            }
        });
    }

    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                modelList.clear();
                getData();
                activityHairStyleImgSwipeRefreshLayout.setRefreshing(false);
            }
        }, 500);
    }
}
