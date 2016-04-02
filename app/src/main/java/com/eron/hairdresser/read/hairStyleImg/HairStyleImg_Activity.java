package com.eron.hairdresser.read.hairStyleImg;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;

import com.eron.hairdresser.R;
import com.eron.hairdresser.TabHost_Activity;
import com.eron.hairdresser.adapter.HairStyleImg_Activity_RecyclerView_Adapter;
import com.eron.hairdresser.model.HairStyleImg_Model;
import com.eron.hairdresser.register.Login_Activity;
import com.eron.hairdresser.views.headTitle.HeadTitle;
import com.lin.framwork.config.ConfigUrl;
import com.lin.framwork.utils.IntentUtil;
import com.lin.framwork.utils.RecycleViewDividerUtil;
import com.lin.framwork.utils.VolleyUtil;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hair_style_img);
        ButterKnife.bind(this);
        Init();
    }

    private void Init() {
        List<HairStyleImg_Model> modelList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            HairStyleImg_Model model = new HairStyleImg_Model();
            if (i % 4 == 0) {
                model.setImg(R.mipmap.img_adapter_read_fragment_girdview_down01);
                model.setTitle("林炜智");
                modelList.add(model);
            } else if (i % 5 == 0) {
                model.setImg(R.mipmap.ic_company_profile);
                model.setTitle("王尼玛");
                modelList.add(model);
            } else {
                model.setImg(R.mipmap.img_adapter_read_fragment_girdview_up02);
                model.setTitle("狗蛋狗蛋狗蛋狗蛋狗蛋狗蛋狗蛋狗蛋狗蛋狗蛋狗蛋狗蛋狗蛋狗蛋狗蛋狗蛋狗蛋");
                modelList.add(model);
            }
        }
        handler = new Handler();
        map = new HashMap<>();
        recyclerView_adapter = new HairStyleImg_Activity_RecyclerView_Adapter(this, modelList);
        recyclerView_adapter.setOnItemClickLitener(new HairStyleImg_Activity_RecyclerView_Adapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                IntentUtil.goToContext(HairStyleImg_Activity.this, Login_Activity.class);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                IntentUtil.goToContext(HairStyleImg_Activity.this, Login_Activity.class);
            }
        });
        Content();
    }

    @TargetApi(Build.VERSION_CODES.M)
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
        new VolleyUtil<>().get(ConfigUrl.HairStyleImg_ActivityUrl, Tag);
    }

    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                getData();
                activityHairStyleImgSwipeRefreshLayout.setRefreshing(false);
            }
        }, 500);
    }
}
